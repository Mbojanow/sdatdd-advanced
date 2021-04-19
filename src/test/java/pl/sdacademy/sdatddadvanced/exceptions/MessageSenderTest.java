package pl.sdacademy.sdatddadvanced.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sdacademy.sdatddadvanced.arguments.enums.User;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MessageSenderTest {

    @Mock
    private UserRepository userRepository;
            //= Mockito.mock(UserRepository.class);
        //= new UserRepository();

    @Mock
    private EmailClient emailClient;
            //= Mockito.mock(EmailClient.class);
            //new EmailClient();

    @InjectMocks
    private MessageSender messageSender;
            //= new MessageSender(userRepository, emailClient);

    @Test
    void shouldSendMessage() throws UserNotFoundException {
        User from = User.builder().email("e1").build();
        User to = User.builder().email("e2").build();
        String messageContent = "hi";
        Mockito.when(userRepository.loadByEmail("e1")).thenReturn(from);
        Mockito.when(userRepository.loadByEmail("e2")).thenReturn(to);
        // metoda typu void
        Mockito.doNothing().when(emailClient).send(ArgumentMatchers.eq(from), ArgumentMatchers.eq(to),
                ArgumentMatchers.any());

        final Message message = messageSender.sendMessage(from, to, messageContent);

        assertThat(message.getEmailFrom()).isEqualTo("e1");
        assertThat(message.getEmailTo()).isEqualTo("e2");
        assertThat(message.getContent()).isEqualTo(messageContent);
    }

}
