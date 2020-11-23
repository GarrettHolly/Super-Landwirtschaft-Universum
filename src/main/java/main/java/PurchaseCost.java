package main.java;

import lombok.Data;

/**
 * Class used to set values of items to purchase.
 * 
 * @return int
 * @return int
 * @return int
 * @return int
 * @return boolean
 * @return boolean
 * @return int
 * @return String
 */
@Data
public class PurchaseCost {
    int sheepCost;
    int cowCost;
    int chickenCost;
    int upgradeFarmCost;

}
