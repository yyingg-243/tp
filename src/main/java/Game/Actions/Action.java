package Game.Actions;

import Functionalities.Storage;
import Functionalities.UI;
import Game.Game;

public interface Action {
    public void execute(Game game, Storage storage, UI ui);
}
