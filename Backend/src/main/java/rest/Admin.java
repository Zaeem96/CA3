package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.UserFacade;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("user")
@RolesAllowed("Admin")
public class Admin {
  
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    UserFacade uf = new UserFacade("pu_development");
    
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getUseres(){
      try {
          return gson.toJson(uf.getUsers());
      } catch(Exception e) {
          throw null;
      }
  }
 
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public String createUser(String content){
      try {
          uf.createUser(gson.fromJson(content, entity.User.class));
          return "{\"isSucced\" : \"Created\"}";
      } catch(Exception e) {
          throw null;
      }
  }
  
}
