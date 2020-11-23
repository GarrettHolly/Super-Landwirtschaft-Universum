# Super-Landwirtschaft-Universum

## **Core Gameplay Mechanics**

This game has incremental elements to it with farm upgrades going up in price each pruchase as well as animals that are purhcased. You start with a Farmer who will gain random stats that will be listed below and each stat increases profit gained within the stats, some being increased profit from crops or just flat increase of overall profit. The farm will spawn in with crops that will be ready to grow after 3 days at which point you can sell them and either upgarde the farm or purchase animals. You can upgarde your farm to increase its size allowing for more areas to grow crops and allowing you to purchase more animals. Each tier of farm holds 5 of each type of animal and 1 plot for crops. Each night predators can attack and kill your animals as well as each day allowing for predators to attack and kill your crops. Your crops can become sick but each day have a chance to be treated by your farmer to stop them from withering. As the game progresses pricing of upgrades as well as animals will increase. There is a chance for rain during the day or night that causes a multiplier on crops if they are harvested when they were rained on. The game will be won once your farm has reached tier 10.

---

## **Design Pattern Usage**

-   **Decorator Design Pattern** - This pattern is being used to created decorated modifiers on the farmers and animals affinities. We can use this to easily expand stats for the games future.
-   **Factory Design Pattern** - This pattern is being used to have a factory that builds the farmers when called upon as well as generate a factory to build the game state. This design allowed for easy setup of difficulty changes for the games future.
-   **Observer Design Pattern** - This pattern was used to generate observers on different outcomes of each RNG situation within the gameloop. This is helpful for easily adding additional changes in the future such as an achievemen tracking system.

---

### **Stats**

Farmers

-   Animal Husbandry
-   Crop Efficiency
-   Flat Profit Gain

Animals

-   Egg Production
-   Milk Production
-   Wool Production

---

#### **Side Notes**

Each animal and farmer stats can change drastically with some being a very high incease of profit gains each playthough should be quite different as far as time is concerened.
