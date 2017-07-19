package pl.kurs.controllers;

import java.io.IOException;

import com.sun.javafx.scene.layout.region.Margins;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MenuController
{

	private MainController mainController;

	@FXML
	public void onApplication()
	{
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AppScreen.fxml"));
		Pane pane = null;
		try
		{
			pane = loader.load();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AppController appController = loader.getController();
		appController.setMainController(mainController);
		mainController.setScreen(pane);
	}

	public void onOptions()
	{
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/OptionsScreen.fxml"));
		Pane pane = null;
		try
		{
			pane = loader.load();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OptionsController optionsController = loader.getController();
		optionsController.setMainController(mainController);
		mainController.setScreen(pane);

	}

	public void onExit()
	{
		Platform.exit();
	}

	public void setMainController(MainController mainController)
	{
		this.mainController = mainController;
	}

}
