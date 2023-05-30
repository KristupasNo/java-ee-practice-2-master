package lt.vu.rest;

import lombok.*;
import lt.vu.entities.Band;
import lt.vu.persistence.BandsDAO;
import lt.vu.rest.contracts.MusicianDto;
import lt.vu.entities.Musician;
import lt.vu.persistence.MusiciansDAO;
import lt.vu.usecases.IValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/musicians")
public class MusicianController {

    @Inject
    @Setter @Getter
    private MusiciansDAO musiciansDAO;

    @Inject
    private BandsDAO bandsDAO;

    @Inject
    private IValidator validator;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Musician> musicians = musiciansDAO.findAll();

        // Transform to DTOs
        List<MusicianDto> musicianDtos = musicians.stream()
                .map(musician -> {
                    MusicianDto dto = new MusicianDto();
                    dto.setName(musician.getName());
                    dto.setInstrument(musician.getInstrument());
                    dto.setBandId(musician.getBand() != null ? musician.getBand().getId() : null);
                    return dto;
                })
                .collect(Collectors.toList());

        return Response.ok(musicianDtos).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Musician musician = musiciansDAO.findOne(id);
        if (musician == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        MusicianDto musicianDto = new MusicianDto();
        musicianDto.setName(musician.getName());
        musicianDto.setInstrument(musician.getInstrument());
        musicianDto.setBandId(musician.getBand() != null ? musician.getBand().getId() : null);

        return Response.ok(musicianDto).build();
    }


    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer musicianId,
            MusicianDto musicianData) {
        try {
            if (!validator.validate(musicianData)) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            Musician existingMusician = musiciansDAO.findOne(musicianId);
            if (existingMusician == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingMusician.setName(musicianData.getName());
            existingMusician.setInstrument(musicianData.getInstrument());

            Band band = bandsDAO.findOne(musicianData.getBandId());
            if (band == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Band not found").build();
            }
            existingMusician.setBand(band);

            musiciansDAO.update(existingMusician);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(MusicianDto musicianData) {
        try {
            if (!validator.validate(musicianData)) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            Musician newMusician = new Musician();
            newMusician.setName(musicianData.getName());
            newMusician.setInstrument(musicianData.getInstrument());

            Band band = bandsDAO.findOne(musicianData.getBandId());
            if (band == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Band not found").build();
            }
            newMusician.setBand(band);

            musiciansDAO.create(newMusician);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            // Handle exception and return an appropriate response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
