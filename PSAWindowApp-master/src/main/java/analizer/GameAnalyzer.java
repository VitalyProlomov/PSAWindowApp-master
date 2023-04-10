package analizer;

import models.Game;
import models.StreetDescription;

import static models.Action.ActionType.RAISE;

public class GameAnalyzer {
    public void analyzeGame(Game game) {
        StreetDescription pf = game.getFlop();
        int raiseCount = 0;
        for (int i = 0; i < pf.getAllActions().size(); ++i) {
            if (pf.getAllActions().get(i).getActionType().equals(RAISE)) {
                ++raiseCount;
            }
        }

    }
}
