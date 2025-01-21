# Lethal Company Enemies mod for Fabric
A Fabric mod that adds some enemies from the game Lethal Company to Minecraft.

I tried to make the enemies as accurate to the originals as I could, but some aspects could not be mapped 1:1 into minecraft (as an example player speeds in the games are different, so i had to choose enemy speeds that felt right)

## Enemies (currently added)

### Coilhead

More Info: https://www.youtube.com/watch?v=sVrxsCFH0AE

* A very fast enemy which kill the player almost instantly. it will stop moving when a player sees it
* After some time chasing the player, it will enter the rest phase
* Opening doors takes ~16 seconds

**Issues**
* All sources I found state, that coilheads will enter the rest phase after *some* time, but none of them specifies it exactly. in the mod it takes 15 seconds, but it should probably be extended
* With multiple coilheads, (for some reason) all of them share the same animations
### Bracken

More Info: https://www.youtube.com/watch?v=A7A36i0v9yA

* Will try to sneak up on a player, if successful it (or he?) will instantly kill the player
* if seen, it will get spooked and run away for 23 seconds
* if looked at for too long, it will get angry and run towards the player

**Issues**
* Some animations are not implemented
* The pathfinding on non-flat surfaces can be a bit broken

## Credits
### Models
Models and their animations were made by my friend @cavemanman (thanks)
### Sounds
The sounds are the original sounds from the game, and they were downloaded from the [Lethal Company Wiki](https://lethal-company.fandom.com)
## Future Plans
I am unlikely to work further on this mod. mainly because the way Minecraft and Lethal Company do enemy AI is quite different, which forced me to write some questionable quality code, which i don't enjoy doing.

If I *do* end up working on this, I would work on the Jester first, as well as adding Lethal Company items.
