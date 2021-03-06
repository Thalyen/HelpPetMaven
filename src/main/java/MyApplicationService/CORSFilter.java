/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ContainerResponse;

/**
 *
 * @author anne
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {

//    @Override
//    public ContainerResponse filter(ContainerRequest containerRequest,
//	    ContainerResponse containerResponse) {
//	ResponseBuilder responseBuilder = Response
//                .fromResponse(containerResponse.getResponse());
//
//	responseBuilder.header("Access-Control-Allow-Origin", "*");
//	responseBuilder.header("Access-Control-Allow-Methods", 
//                "POST, GET, OPTIONS");
//	responseBuilder.header("Access-Control-Allow-Headers", 
//                "Foo-Header");
//        responseBuilder.header("Access-Control-Max-Age",
//                "86400");
//
//	containerResponse.setResponse(responseBuilder.build());
//
//	return containerResponse;
//    }
    @Override
    public void filter(ContainerRequestContext requestContext,
	    ContainerResponseContext responseContext) throws IOException {
	//responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");

	MultivaluedMap<String, Object> headers = responseContext.getHeaders();

	headers.add("Access-Control-Allow-Origin", "*");
	//headers.add("Access-Control-Allow-Origin", "http://podcastpedia.org"); //allows CORS requests only coming from podcastpedia.org		
	headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
	headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");

    }
}
