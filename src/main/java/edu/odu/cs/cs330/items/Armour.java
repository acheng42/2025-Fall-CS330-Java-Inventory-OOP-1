package edu.odu.cs.cs330.items;

import java.util.Scanner;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable {
    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with an empty name, zero durability, zero defense,
     * blank material, no modifier a zero modifier level, and a blank element.
     */
    public Armour()
    {
        super();
        this.defense = 0;
    }

    /**
     * Duplicate a piece of armour.
     *
     * @param src armour to duplicate
     */
    public Armour(Armour src)
    {
        super(src.name);
        super.setDurability(src.durability);
        super.setMaterial(src.material);
        super.setModifier(src.modifier);
        super.setModifierLevel(src.modifierLevel);
        super.setElement(src.element);
        this.defense = src.defense;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement defense
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    /**
     * Read Armour attributes.
     */
    @Override
    public void read(Scanner snr)
    {
        super.name = snr.next();
        super.material = snr.next();
        super.durability = snr.nextInt();
        this.defense = snr.nextInt();
        super.modifier = snr.next();
        super.modifierLevel = snr.nextInt();
        super.element = snr.next();
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Armour clone()
    {
       Armour clone = new Armour();
       clone.setName(this.name);
       clone.setDurability(this.durability);
       clone.setMaterial(this.material);
       clone.setModifier(this.modifier);
       clone.setModifierLevel(this.modifierLevel);
       clone.setElement(this.element);
       clone.setDefense(this.defense);
       return clone;
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
        return String.join(
            System.lineSeparator(),
            String.format("  Nme: %s", super.getName()),
            String.format("  Dur: %d", super.getDurability()),
            String.format("  Def: %d", this.getDefense()),
            String.format("  Mtl: %s", super.getMaterial()),
            String.format("  Mdr: %s (Lvl %d)", super.getModifier(), super.getModifierLevel()),
            String.format("  Emt: %s%n", super.getElement())
        );
    }
}




