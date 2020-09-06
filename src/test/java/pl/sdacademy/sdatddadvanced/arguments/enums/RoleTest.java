package pl.sdacademy.sdatddadvanced.arguments.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class RoleTest {

  @EnumSource(value = Role.class, names = {"READER", "CRUD_ADMIN"})
  @ParameterizedTest
  void shouldHaveReadAccess(final Role role) {
    final List<AccessType> accessTypes = role.getAccessTypes();

    assertThat(accessTypes).contains(AccessType.READ);
  }

  @EnumSource(value = Role.class, names = {"READER", "CRUD_ADMIN"}, mode = EnumSource.Mode.EXCLUDE)
  @ParameterizedTest
  void shouldNotHaveReadAccess(final Role role) {
    final List<AccessType> accessTypes = role.getAccessTypes();

    assertThat(accessTypes).doesNotContain(AccessType.READ);
  }
}