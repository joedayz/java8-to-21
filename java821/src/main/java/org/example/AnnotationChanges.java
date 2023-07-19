package org.example;

import javax.validation.constraints.NotNull;

@Allow(group="Managers")
@Allow(group="SeniorManagers")
public class AnnotationChanges {

  public @NotNull ResponseObject method(@NotNull String arg){
    return new ResponseObject();
  }
}

class ResponseObject{

}
