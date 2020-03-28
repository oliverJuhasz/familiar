package familiar.domain.character;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Name {
    String firstName;
    String lastName;
    String title;
    String nickName;
}
