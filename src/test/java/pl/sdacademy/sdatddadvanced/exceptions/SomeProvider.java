package pl.sdacademy.sdatddadvanced.exceptions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class SomeProvider implements ArgumentsProvider {
  @Override
  public Stream<? extends Arguments> provideArguments(final ExtensionContext context) throws Exception {
    return null;
  }
}
