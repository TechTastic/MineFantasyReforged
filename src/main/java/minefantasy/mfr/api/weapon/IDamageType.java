package minefantasy.mfr.api.weapon;

public interface IDamageType {
    /**
     * Gets the cutting:blunt ratio. use any 3 numbers, the relevant values is what
     * matters
     *
     * @param implement the object causing the damage, this is "ItemStack" for items and
     *                  "Entity" for projectiles This can therefore be implemented by
     *                  projectile entities and items
     */
    float[] getDamageRatio(Object... implement);

    /**
     * Gets the "Penetration" level: this modifies the armour rating of supported
     * armours, 0 means no effect
     *
     * @param implement the object causing the damage, this is "ItemStack" for items and
     *                  "Entity" for projectiles This can therefore be implemented by
     *                  projectile entities and items
     */
    float getPenetrationLevel(Object implement);
}
