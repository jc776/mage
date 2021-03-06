package mage.cards.e;

import mage.MageInt;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.dynamicvalue.DynamicValue;
import mage.abilities.dynamicvalue.common.DevotionCount;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.hint.ValueHint;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.ColoredManaSymbol;
import mage.constants.SubType;
import mage.game.permanent.token.SoldierToken;

import java.util.UUID;

/**
 * @author LevelX2
 */
public final class EvangelOfHeliod extends CardImpl {

    private static final DynamicValue xValue = new DevotionCount(ColoredManaSymbol.W);

    public EvangelOfHeliod(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{4}{W}{W}");
        this.subtype.add(SubType.HUMAN);
        this.subtype.add(SubType.CLERIC);

        this.power = new MageInt(1);
        this.toughness = new MageInt(3);

        // When Evangel of Heliod enters the battlefield, create a number of 1/1 white Soldier creature tokens equal to your devotion to white.
        this.addAbility(new EntersBattlefieldTriggeredAbility(new CreateTokenEffect(new SoldierToken(), xValue))
                .addHint(new ValueHint("Devotion to white", xValue)));
    }

    public EvangelOfHeliod(final EvangelOfHeliod card) {
        super(card);
    }

    @Override
    public EvangelOfHeliod copy() {
        return new EvangelOfHeliod(this);
    }
}
