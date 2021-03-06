package edu.ucsb.cs56.projects.games.poker;

import java.io.Serializable;
import java.util.*;


/**
   Abstract class that represents a poker player
*/
public abstract class Player implements Serializable {
    /**
     * The player's current hand
     */
    private Hand pokerHand;

    /**
     * The amount of chips the player currently has
     */
    private int chips;

    /**
     * The number of wins the player has in the current round
     */
    private int wins;

    /**
     * The current PokerGame the player is a part of
     */
    public PokerGame delegate;

    /** 
     *Creates a Poker player with a set hand 
     * @param hand the hand you have
     */
    public Player(Hand hand){
        pokerHand = hand;
        chips = 100;
        wins = 0;
    }

    /**
     * Creates a Poker player with a designated number of chips
     * @param chips number of chips
     * @param deck of Cards
     */
    public Player(int chips, Deck deck) {
        this.pokerHand = new Hand(deck);
        this.chips = chips;
        this.wins = 0;
    }

    /**
     * Get Player's Hand
     * @return Hand
     */
    public Hand getHand() {
        return pokerHand;
    }
	
	
    /**
     * Get Player's Chips
     * @return int
     */
    public int getChips() {
        return chips;
    }

    /**
     * Set number of chips player has
     * @param chips number of chips to give to player
     */
    // Might never need to be used---Check later
    public void setChips(int chips) {
        this.chips = chips;
    }

    /**
     * Get number of player wins
     * @return int
     */
    public int getWins() {
        return wins;
    }

    /**
     * Increment player's wins by one
     */
    public void win() {
        wins += 1;
    }

    /**
     * Bet chips
     * @param chipsBet number of chips to bet
     */
    public void bet(int chipsBet) {
        if (chipsBet <= 0)
	    ; // Assert an Error "Not Valid"
        else if (chipsBet > chips)
            ; // Assert an Error "Not Enough Chips"
        else
            chips -= chipsBet;
    }

    /**
     * Fold hand, calls delegate fold method
     */
    // Might never need to be used---Check later
    public void foldHand() {
        delegate.fold();
    }
    
    public void setDelegate(PokerGame game) {
        this.delegate = game;
    }

    /**
     * Performs a player's turn
     * This behavior changes depending on if the player is human or AI
     * and must be implemented by the subclass (User or OpponentAI)
     */
    public abstract void takeTurn(); 
}
