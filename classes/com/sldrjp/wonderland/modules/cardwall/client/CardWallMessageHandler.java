/*
 * Copyright 2010, 2011  Service de logiciel et developpement R.J. Potter (Robert J Potter)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.sldrjp.wonderland.modules.cardwall.client;

import com.sldrjp.wonderland.modules.cardwall.common.CardWallSyncMessage;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Bob
 * Date: 30/01/11
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardWallMessageHandler {

    private CardWallManager cardWallManager;
    private static final Logger logger = Logger.getLogger(CardWallMessageHandler.class.getName());

    public CardWallMessageHandler(CardWallManager cardWallManager) {
        this.cardWallManager = cardWallManager;
    }

    public void handleMessage(final CardWallSyncMessage cardWallMessage) {
        logger.fine(cardWallMessage.toString());
        switch (cardWallMessage.getMessageType()) {
            case CardWallSyncMessage.ADD_CARD:
                cardWallManager.addCard(cardWallMessage.getCardClientState());
                break;

            case CardWallSyncMessage.DELETE_CARD:

                cardWallManager.removeCard(cardWallMessage.getCardClientState().getCardPosition());
                break;

            case CardWallSyncMessage.CHANGE_TEXT:
                cardWallManager.updateCard(cardWallMessage.getCardClientState());
                break;
            case CardWallSyncMessage.MOVE_CARD:
                cardWallManager.moveCard(cardWallMessage.getOriginalCardPosition(), cardWallMessage.getCardClientState());
                break;
            case CardWallSyncMessage.UPDATE_SECTION_TITLE:
                cardWallManager.changeSectionTitle(cardWallMessage.getSection(), cardWallMessage.getText());
                break;

            case CardWallSyncMessage.COMPLETE_STATE:
                cardWallManager.reConfigureWall(cardWallMessage.getClientState(), false);
                break;

            case CardWallSyncMessage.RESTORE_CARD:
                cardWallManager.restoreCard(cardWallMessage.getCardClientState());
                break;
        }
        //@todo process remaining message types
    }
}
