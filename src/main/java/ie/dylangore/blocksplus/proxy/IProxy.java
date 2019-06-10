/*
 * Project: BlocksPlus
 * File: IProxy.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.proxy;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public interface IProxy {
    void setup(final FMLCommonSetupEvent event);
}
