package semicolon.bime.dto.responses;

import lombok.*;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class UserRegisterResponse {
    private String username;
    private String email;
}
