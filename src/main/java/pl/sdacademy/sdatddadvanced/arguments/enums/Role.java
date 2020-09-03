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
  SUPER_ADMIN();


  private final List<AccessType> accessTypes;

  Role(final AccessType accessType, final AccessType ...accessTypes) {
    this.accessTypes = new ArrayList<>(Arrays.asList(accessTypes));
    this.accessTypes.add(accessType);
  }

  Role() {
    this.accessTypes = Arrays.asList(AccessType.values());
  }
}
