package magus.modifiers.attribmods;

import magus.exceptions.InvalidAttributeException;
import magus.model.Attributes;
import magus.model.Race;

public class SummarizedAttributeModifiers {

    //region Fields Properties and Constructor

    private RacialAttributeModifiers ram;
    private AgeAttributeModifiers aam;

    public RacialAttributeModifiers getRam() { return ram; }
    public void setRam(RacialAttributeModifiers ram) { this.ram = ram; }

    public AgeAttributeModifiers getAam() { return aam; }
    public void setAam(AgeAttributeModifiers aam) { this.aam = aam; }


    public SummarizedAttributeModifiers(){
        this.ram = new RacialAttributeModifiers();
        this.aam = new AgeAttributeModifiers();
    }

    //endregion

    //region These functions summarizing the racial and the age modifiers into one integer which will change -or not- the main attribute

    public int StrengthModifier(Race race, int age){
        int modifier = getRam().StrengthRacialModifier(race) + getAam().StrengthAgeModifier(race, age);
        return modifier;
    }

    public int DexterityModifier(Race race, int age){
        int modifier = getRam().DexterityRacialModifier(race) + getAam().DexterityAgeModifier(race, age);
        return modifier;
    }

    public int QuicknessModifier(Race race, int age){
        int modifier = getRam().QuicknessRacialModifier(race) + getAam().QuicknessAgeModifier(race, age);
        return modifier;
    }

    public int EnduranceModifier(Race race, int age){
        int modifier = getRam().EnduranceRacialModifier(race) + getAam().EnduranceAgeModifier(race, age);
        return modifier;
    }

    public int HealthModifier(Race race, int age){
        int modifier = getRam().HealthRacialModifier(race) + getAam().HealthAgeModifier(race, age);
        return modifier;
    }

    public int BeautyModifier(Race race, int age){
        int modifier = getRam().BeautyRacialModifier(race) + getAam().BeautyAgeModifier(race, age);
        return modifier;
    }

    public int IntelligenceModifier(Race race){
        int modifier = getRam().IntelligenceRacialModifier(race);   //intelligence has no age modifier
        return modifier;
    }

    public int AstralModifier(Race race){
        int modifier = getRam().AstralRacialModifier(race);
        return modifier;
    }

    public int PerceptionModifier(Race race){
        int modifier = getRam().PerceptionRacialModifier(race);
        return modifier;
    }
    //will has no modifiers just coming from the dice roll

    //endregion

    public void modifyAttribute(Attributes atr, Race race, int age) throws InvalidAttributeException {
        atr.setStrength( atr.getStrength() + StrengthModifier(race, age) );
        atr.setDexterity( atr.getDexterity() + DexterityModifier(race, age) );
        atr.setQuickness( atr.getQuickness() + QuicknessModifier(race, age) );
        atr.setEndurance( atr.getEndurance() + EnduranceModifier(race, age) );
        atr.setHealth( atr.getHealth() + HealthModifier(race, age) );
        atr.setBeauty( atr.getBeauty() + BeautyModifier(race, age) );
        atr.setIntelligence( atr.getIntelligence() + IntelligenceModifier(race) );
        atr.setAstral( atr.getAstral() + AstralModifier(race) );
        atr.setPerception( atr.getPerception() + PerceptionModifier(race) );
    }
}
