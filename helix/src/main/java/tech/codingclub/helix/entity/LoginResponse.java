package tech.codingclub.helix.entity;

public class LoginResponse
{
   public Long id;
   public String message;
   public Boolean is_logined;

   public LoginResponse()
   {

   }

   public LoginResponse(Long id,Boolean is_logined,String message)
   {
       this.id=id;
       this.message=message;
       this.is_logined=is_logined;
   }

}
