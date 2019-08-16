package eg.edu.alexu.csd.oop.game.world;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new eg.edu.alexu.csd.oop.game.world.Game(new Easy());
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem pauseMenuItem = new JMenuItem("Pause");
		JMenuItem resumeMenuItem = new JMenuItem("Resume");
		JMenuItem save = new JMenuItem("Save Snapshot");
		JMenuItem load = new JMenuItem("Load Snapshot");
		JMenuItem easy = new JMenuItem("New Easy");
		JMenuItem medium = new JMenuItem("New Medium");
		JMenuItem hard = new JMenuItem("New Hard");
		save.setEnabled(false);
		load.setEnabled(false);
		menu.add(easy);
		menu.add(medium);
		menu.add(hard);
		menu.addSeparator();
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);
		menu.addSeparator();
		menu.add(save);
		menu.add(load);
		menu.addSeparator();
		menuBar.add(menu);
		GameController g = GameEngine.start("Circus of plates", game, menuBar, Color.WHITE);
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.changeWorld(new eg.edu.alexu.csd.oop.game.world.Game(new Easy()));
			}
		});
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.changeWorld(new eg.edu.alexu.csd.oop.game.world.Game(new Medium()));
			}
		});
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.changeWorld(new eg.edu.alexu.csd.oop.game.world.Game(new Hard()));
			}
		});
		pauseMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.pause();
				System.out.println("pause");
				save.setEnabled(true);
				load.setEnabled(true);
			}
		});
		resumeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.resume();
				System.out.println("resume");
				save.setEnabled(false);
				load.setEnabled(false);
			}
		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.SaveSnapShot();
			}
		});
		load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.loadSnapShot();
			}
		});
	}

}
