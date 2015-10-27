package it.toto.services.awsJenkins;

import it.toto.services.awsJenkins.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by toto on 07/10/14.
 */
@Slf4j
@Provider
@Produces (MediaType.APPLICATION_JSON)
public class ApiMapperConstraintViolationException implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {

        log.error("Trapped an unexpected throws.", e);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ErrorResponse.of(e)).build();
    }

}