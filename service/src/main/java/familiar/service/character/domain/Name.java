package familiar.service.character.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Name {

    private long id;
    private String firstName;
    private String lastName;
    private String title;
    private String nickName;

}
