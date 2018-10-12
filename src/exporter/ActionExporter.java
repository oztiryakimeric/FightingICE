package exporter;

import struct.CharacterData;
import struct.FrameData;

public class ActionExporter extends CSVExporter {

    @Override
    public String[] getHeaders() {
        return new String[] {"PLAYER1_POS_X", "PLAYER1_POS_Y", "PLAYER1_ACTION", "PLAYER1_HP" ,
            "PLAYER2_POS_X", "PLAYER2_POS_Y", "PLAYER2_ACTION", "PLAYER2_HP"};
    }

    @Override
    public String[] getRow() {
        return createPlayerDatas(frameData.getCharacter(true),
            frameData.getCharacter(false));
    }

    private String[] createPlayerDatas(CharacterData player1, CharacterData player2) {
        return new String[] {String.valueOf(player1.getCenterX()),
            String.valueOf(player1.getCenterY()), String.valueOf(player1.getAction()),
            String.valueOf(player1.getHp()), String.valueOf(player2.getCenterX()),
            String.valueOf(player2.getCenterY()), String.valueOf(player2.getAction()),
            String.valueOf(player2.getHp())};
    }
}
