package tech.mattico.minecraftAI;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/* The responsibility of this class is to be the hands of the AI.
  Keyboard/mouse output is set here and shouldn't be accessed from anywhere else
  It uses the eyes to monitor it's progress to determine world position */

public class MinecraftAIHands
{
    //these are the errors you can get from requests
    enum HandError {OK,BUSY};

    //keep track if the hands are doing something
    private boolean busy = false;

    //We'll likely need to upgrade to a state machine eventually
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }

    /* checks whether the hands are busy */
    public boolean isBusy(){
      return busy;
    }

    /* Requests the hands to attempt to move to a new position */
    /* this coordinate should be the block right above the one you want to stand on */
    public HandError moveTo(coordinates ){
      if (busy) return BUSY;
      busy = true;
      busy = false;
      return OK;
    }

    /* in case the brain ever wants to jump just for fun */
    /* this pretty much always succeeds */
    public HandError jump(){
      return OK;
    }

    /* opens the inventory */
    public HandError openInventory(){
      return BUSY;
    }

    /* closes the inventory */
    public HandError closeInventory(){
      return BUSY;
    }

    /* This gets an item from your inventory
      It puts the new item in whatever slot has been resetly used
      -1 quanity is all
    */
    public HandError getItemFromInventory(int x, int y, int quanity){
      openInventory();
      closeInventory()
      return BUSY;
    }
    /*
      this puts an item into a chest
      -1 quanity is all
    */
    public HandError getItemFromChest(chestposition, int x, int y, int quanity){
      return BUSY;
    }

    public HandError putItemIntoChest(chestposition, int x, int y, int quanity){
      return BUSY;

    }

    /* equipts an item from the player quick access bar */
    public HandError equiptItem(int number){
      return BUSY;
    }

    /* sets the sprinting state to yes or no */
    public HandError setSprinting(boolean sprint){
      //set shift to be held down
      return OK;
    }

    /* Attacks a specific mob */
    public HandError attackMob(mob ){
      if (busy) return BUSY;
      busy = true;
      busy = false;
      return OK;
    }


    /* This just looks at the coordinates and places the block */
    /* orientation is needed but if it can be acheived, it will return an error */
    public HandError placeBlock(coordinates, orientation){
      if (busy) return BUSY;
      busy = true;
      busy = false;
      //figure out the orientation needed and attempt to move there if we can
      lookAt(coordinates);
      //place the block
      useItem();
      return OK;
    }

    /* This looks at a block and then places it*/
    public boolean mineBlock(coordinates ){
      if (busy) return false;
      busy = true;
      busy = false;
      //figure out how to look at the block
      lookAt(coordinates);
      //mine it

      return true;
    }

    /* This looks at a coordinates and places the block needed */
    public HandError lookAt(coordinates){
      if (busy) return BUSY;
      busy = true;
      busy = false;
      return OK;
    }
}
