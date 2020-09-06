package pl.sdacademy.sdatddadvanced.arguments.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum Role {
  DUMMY,
  READER(AccessType.READ),
  CRUD_ADMIN(AccessType.READ, AccessType.CREATE, AccessType.DELETE, AccessType.UPDATE),
  HELP_DESK(AccessType.REVOKE, AccessType.GRANT),
  SUPER_ADMIN("all_roles");


  private final List<AccessType> accessTypes;

  Role(final AccessType ...accessTypes) {
    this.accessTypes = new ArrayList<>(Arrays.asList(accessTypes));
  }

  Role(String all) {
    this.accessTypes = Arrays.asList(AccessType.values());
  }
}
