package com.abbaskareem;

import com.sun.security.jgss.GSSUtil;

import java.awt.*;
import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Strombringer", "Deep purple");

        album.addSong("Strombringer", 4.3);
        album.addSong("Love don't mean a thing", 4.1);
        album.addSong("Holy man", 3.2);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("High ball shooter", 4.4);
        album.addSong("Solder of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC:DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put a finger on you", 4.2);
        album.addSong("Lets go", 3.1);
        album.addSong("Inject the venom", 5.6);
        album.addSong("Snowballed", 2.1);
        album.addSong("Evils walks", 5.3);
        album.addSong("C.O.D.", 4.3);
        album.addSong("Breaking the rules", 5.44);
        album.addSong("Night of the long knives", 5.44);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList); // does not exists
        albums.get(0).addToPlayList(9, playList);

        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);


        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playList");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("PlayList complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now palying " + listIterator.next().toString());
                    } else {
                        System.out.println("You reached the end of playList ");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("You are at the start of playList");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start fo list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }
                    } else {
                        System.out.println("PlayList is empty");
                    }
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("""
                0 - to quit
                1 - to play next song
                2 - to play previous song
                3 - to replay the current song
                4 - list songs in playlist
                5 - print available action.
                6 - delete current song from playList
                                
                """);
    }


    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("======================================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
            System.out.println("--------------------------------------");
        }
    }


}
