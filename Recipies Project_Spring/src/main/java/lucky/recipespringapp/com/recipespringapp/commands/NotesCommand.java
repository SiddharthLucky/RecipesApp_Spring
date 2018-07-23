package lucky.recipespringapp.com.recipespringapp.commands;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotesCommand
{
    private Long id;
    private String recipeNotes;
}
