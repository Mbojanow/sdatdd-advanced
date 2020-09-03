package pl.sdacademy.sdatddadvanced.arguments.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
  private String firstName;
  private String lastName;
  private String email;
  private Role role;

  public boolean hasAccessType(final AccessType accessType) {
    return false;
  }
}
