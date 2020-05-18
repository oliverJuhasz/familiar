package familiar.service.character.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Name {

    private long id;
    private String firstName;
    private String lastName;
    private String title;
    private String nickName;

}
