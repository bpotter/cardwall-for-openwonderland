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

package com.sldrjp.wonderland.modules.cardwall.common.cell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bpotter
 * Date: 12-Oct-2010
 * Time: 8:08:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListConverter {


    public static <T> List<T> copyAsServerState(Class T, List items) {


        if (items == null) {
            return null;
        }

        List<T> copyOfItems = new ArrayList<T>(items.size());
        for (StateConvertable item : (List <StateConvertable>) items) {
            copyOfItems.add((T) item.getCopyAsServerState());
        }


        return copyOfItems;
    }

    public static <T> List<T> copyAsClientState(Class T, List items) {

        List<T> copyOfItems = new ArrayList<T>(items.size());
        for (StateConvertable item :  (List <StateConvertable>) items) {
            copyOfItems.add((T) item.getCopyAsClientState());
        }

        return copyOfItems;
    }
}
