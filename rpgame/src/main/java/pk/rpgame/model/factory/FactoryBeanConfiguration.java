package pk.rpgame.model.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pk.rpgame.model.factory.item.ArmorItemsFactory;
import pk.rpgame.model.factory.item.PotionItemsFactory;
import pk.rpgame.model.factory.monster.LizardMonsterFactory;
import pk.rpgame.model.items.ArmorItem;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.items.Potion;
import pk.rpgame.model.living.Lizard;
import pk.rpgame.model.living.Monster;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FactoryBeanConfiguration {
    // use @Resource(name = "name") to inject a bean
    // or @Resource(name = "&name") to access the FactoryBean

    @Bean(name = "weakArmorItem")
    public ArmorItemsFactory weakArmorItemsFactory() {
        ArmorItemsFactory factory = new ArmorItemsFactory();
        factory.setItemName("Weak Armor");
        factory.setDefense(5);
        return factory;
    }

    @Bean
    public ArmorItem weakArmorItem() throws Exception {
        return weakArmorItemsFactory().getObject();
    }

    @Bean(name = "strongArmorItem")
    public ArmorItemsFactory strongArmorItemsFactory() {
        ArmorItemsFactory factory = new ArmorItemsFactory();
        factory.setItemName("Strong Armor");
        factory.setDefense(20);
        return factory;
    }

    @Bean
    public ArmorItem strongArmorItem() throws Exception {
        return strongArmorItemsFactory().getObject();
    }


    @Bean(name = "weakPotionItem")
    public PotionItemsFactory weakPotionItemsFactory() {
        PotionItemsFactory factory = new PotionItemsFactory();
        factory.setItemName("potion");
        factory.setHealth(5);
        return factory;
    }

    @Bean
    public Potion weakPotionItem() throws Exception {
        return weakPotionItemsFactory().getObject();
    }

    @Bean(name = "strongPotionItem")
    public PotionItemsFactory strongPotionItemsFactory() {
        PotionItemsFactory factory = new PotionItemsFactory();
        factory.setItemName("potion");
        factory.setHealth(20);
        return factory;
    }

    @Bean
    public Potion strongPotionItem() throws Exception {
        return strongPotionItemsFactory().getObject();
    }


    @Bean(name = "lizardMonsterWithPotion")
    public LizardMonsterFactory lizardMonsterFactory() throws Exception {
        LizardMonsterFactory factory = new LizardMonsterFactory();
        factory.setMonsterName("Lizard");
        factory.setMonsterLevel(5);
        factory.setMonsterStrength(3);
        factory.setMonsterHealth(15);
        factory.setMonsterMaxHealth(15);
        List<Item> lizardItems = new ArrayList<>();
        lizardItems.add(strongPotionItemsFactory().getObject());
        factory.setMonsterItems(lizardItems);
        factory.setMonsterHealth(20);
        return factory;
    }

    @Bean
    public Lizard lizardMonster() throws Exception {
        return lizardMonsterFactory().getObject();
    }

}
