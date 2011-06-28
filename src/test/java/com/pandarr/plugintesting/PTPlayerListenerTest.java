/**
 * 
 */
package com.pandarr.plugintesting;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Pandarr
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PlayerJoinEvent.class)
public class PTPlayerListenerTest {
    /**
     * Test method for
     * {@link com.pandarr.plugintesting.PTPlayerListener#onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent)}
     * .
     */
    @Test
    public void testOnPlayerJoin() {
        /*
         * Set up our fake PlayerJoinEvent
         */
        
        // we have to use PowerMockito.mock because .getPlayer() is a final method
        PlayerJoinEvent mockEvent = PowerMockito.mock(PlayerJoinEvent.class);
        
        /*
         * Set up our first Player
         */
        
        // we are not calling any final methods on this class so can just use Mockitos normal mock
        Player mockPlayerPandarr = mock(Player.class);

        // effectively set the player name to "Pandarr"
        when(mockPlayerPandarr.getName()).thenReturn("Pandarr");

        // when our onPlayerJoin calls .getPlayer(), we want to return this mockPlayer
        when(mockEvent.getPlayer()).thenReturn(mockPlayerPandarr);

        // create our listener
        PTPlayerListener myPlayerListener = new PTPlayerListener();
        // send in our mock event
        myPlayerListener.onPlayerJoin(mockEvent);

        // verify that our mockPlayer had sendMessage called
        //   we don't care what the string was
        verify(mockPlayerPandarr).sendMessage(anyString());
        
        /*
         * Set up our second Player
         */
        
        // we are not calling any final methods on this class so can just use Mockitos normal mock
        Player mockPlayerCodenameB = mock(Player.class);

        // effectively set the player name to "CodenameB"
        when(mockPlayerCodenameB.getName()).thenReturn("CodenameB");

        // when our onPlayerJoin calls .getPlayer(), we want to return this mockPlayer
        when(mockEvent.getPlayer()).thenReturn(mockPlayerCodenameB);

        // send in our mock event
        myPlayerListener.onPlayerJoin(mockEvent);
        
        // verify we did not send this player a message
        verify(mockPlayerCodenameB, never()).sendMessage(anyString());
    }
}
