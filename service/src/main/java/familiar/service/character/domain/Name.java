package familiar.service.character.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Name {

    private long id;
    private String firstName;
    private String lastName;
    private String title;
    private String nickName;

}
