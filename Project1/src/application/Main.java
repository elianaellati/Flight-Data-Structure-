 package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main extends Application {

	@Override

	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			GridPane g = new GridPane();
			Image cc = new Image("planee.jpg");
			ImageView imageVieww = new ImageView(cc);
			imageVieww.setFitHeight(140);
			imageVieww.setFitWidth(180);
			Button btt1 = new Button("", imageVieww);
			btt1.setMinHeight(25);
			btt1.setMinWidth(25);
			;
			Image c = new Image("pass.jpg");
			ImageView imageView = new ImageView(c);
			imageView.setFitHeight(140);
			imageView.setFitWidth(180);
			Button bt = new Button("", imageView);
			bt.setMinHeight(25);
			bt.setMinWidth(25);
			LinkedList<Flight> m = new LinkedList();
			Button data = new Button("Read Data");
			g.add(data, 0, 0);
			data.setFont(Font.font(15));
			data.setFont(Font.font(null, FontWeight.BOLD, data.getFont().getSize()));
			data.setMinWidth(300);
			data.setMinHeight(50);
			Button flight = new Button("Display information about flights");
			g.add(flight, 0, 1);
			flight.setFont(Font.font(15));
			flight.setFont(Font.font(null, FontWeight.BOLD, flight.getFont().getSize()));
			flight.setMinWidth(300);
			flight.setMinHeight(50);
			Button passenger = new Button("Display information about Passengers");
			// passenger.setMinWidth(250);
			passenger.setFont(Font.font(15));
			passenger.setFont(Font.font(null, FontWeight.BOLD, passenger.getFont().getSize()));
			passenger.setMinWidth(300);
			passenger.setMinHeight(50);
			g.add(passenger, 0, 2);
			Button add = new Button("Add/Edit a flight");
			add.setFont(Font.font(15));
			add.setFont(Font.font(null, FontWeight.BOLD, add.getFont().getSize()));
			add.setMinWidth(300);
			add.setMinHeight(50);
			g.add(add, 0, 3);
			Button reserve = new Button("Reserve a ticket");
			reserve.setFont(Font.font(15));
			reserve.setFont(Font.font(null, FontWeight.BOLD, reserve.getFont().getSize()));
			reserve.setMinWidth(300);
			reserve.setMinHeight(50);
			g.add(reserve, 0, 4);
			Button cancel = new Button("cancel a reservation");
			cancel.setFont(Font.font(15));
			cancel.setFont(Font.font(null, FontWeight.BOLD, cancel.getFont().getSize()));
			cancel.setMinWidth(300);
			cancel.setMinHeight(50);
			g.add(cancel, 0, 5);
			Button search = new Button("Search for a specific passenger");
			search.setFont(Font.font(15));
			search.setFont(Font.font(null, FontWeight.BOLD, search.getFont().getSize()));
			search.setMinWidth(300);
			search.setMinHeight(50);
			g.add(search, 0, 6);
			Button check = new Button("Check for Reserved Ticket");
			check.setFont(Font.font(15));
			check.setFont(Font.font(null, FontWeight.BOLD, check.getFont().getSize()));
			check.setMinWidth(300);
			check.setMinHeight(50);
			g.add(check, 0, 7);
			Button Exit = new Button("Exit");
			Exit.setFont(Font.font(15));
			Exit.setFont(Font.font(null, FontWeight.BOLD, Exit.getFont().getSize()));
			Exit.setMinWidth(300);
			Exit.setMinHeight(50);
			g.add(Exit, 0, 8);

			Image image1 = new Image("plus.png");
			Button btt = new Button("", new ImageView(image1));
			btt.setMinHeight(50);
			btt.setMinWidth(30);
			btt.setAlignment(Pos.CENTER);
			g.setHgap(5);
			g.setVgap(15);
			
			root.setStyle("-fx-background-color: pink ;");
			Scene scene1 = new Scene(root, 1550, 800);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
			data.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					BorderPane o = new BorderPane();
					o.setStyle("-fx-background-color: pink ;");
					GridPane g = new GridPane();
					Label flnum = new Label("Flight File ");
					flnum.setFont(Font.font(25));
					flnum.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
					g.add(flnum, 0, 0);
					g.add(btt1, 1, 0);
					Label flnu = new Label("Passengers File ");
					flnu.setFont(Font.font(25));
					flnu.setFont(Font.font(null, FontWeight.BOLD, flnu.getFont().getSize()));
					g.add(flnu, 0, 1);
					g.add(bt, 1, 1);

					btt1.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							FileChooser fileChooser = new FileChooser();
							File selectedFile = fileChooser.showOpenDialog(primaryStage);
							Scanner sc = null;
							try {
								sc = new Scanner(selectedFile);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (selectedFile.length() != 0) {

								while (sc.hasNextLine()) {
									String line = sc.nextLine();
									String[] token = line.split(",");
									line.trim();
									if (token.length == 5) {

										m.insert(new Flight(Integer.parseInt(token[0]), token[1], token[2], token[3],
												Integer.parseInt(token[4])));
									} else {

									}

								}
							}
						}
					});
					bt.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							FileChooser fileChooserr = new FileChooser();
							File selectedFilee = fileChooserr.showOpenDialog(primaryStage);
							Scanner sc1 = null;
							try {
								sc1 = new Scanner(selectedFilee);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if (selectedFilee.length() != 0) {

								while (sc1.hasNextLine()) {
									String line = sc1.nextLine();
									String[] token = line.split(",");
									int x = Integer.parseInt(token[0]);
									Node<Flight> curr = m.head;
									while (curr != null) {

										if (curr.getF().getFlightnumber() == x && curr.getF().capacity() == true
												&& token.length == 6) {
											try {
												curr.getF().p.insert(new Passengers(Integer.parseInt(token[0]),
														token[1], token[2], token[3], token[4], token[5]));
											} catch (NumberFormatException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										curr = curr.getNext();

									}
								}
							}

						}
					});
					Image image33 = new Image("back.png");
					Button b2 = new Button("", new ImageView(image33));
					b2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(scene1);

						}

					});
					g.setAlignment(Pos.CENTER);
					g.setHgap(5);
					g.setVgap(20);
					o.setCenter(g);
					o.setAlignment(b2, Pos.CENTER);
					o.setBottom(b2);
					Scene scene = new Scene(o, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();

				}
			});
			flight.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {

					BorderPane o = new BorderPane();
					o.setStyle("-fx-background-color: pink ;");
					GridPane g = new GridPane();
					Label flnum = new Label("Flight's Information :");
					flnum.setFont(Font.font(25));
					flnum.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
					g.add(flnum, 0, 0);
					TextArea area1 = new TextArea();
					area1.setPrefWidth(1000);
					area1.setPrefHeight(500);

					g.setAlignment(Pos.CENTER);
					o.setCenter(g);
					m.checkkk();
					area1.setFont(Font.font(15));
					area1.setFont(Font.font(null, FontWeight.BOLD, area1.getFont().getSize()));
					area1.appendText(m.printt());

					g.add(area1, 0, 2);
					g.setAlignment(Pos.CENTER);
					o.setCenter(g);
					Image image33 = new Image("back.png");
					Button b2 = new Button("", new ImageView(image33));
					b2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(scene1);

						}

					});

					m.print();
					HBox h = new HBox();
					h.getChildren().addAll(btt, b2);
					h.setAlignment(Pos.CENTER);
					h.setSpacing(15);
					o.setBottom(h);
					g.setAlignment(Pos.CENTER);
					o.setCenter(g);
					g.setHgap(5);
					g.setVgap(20);

					Scene scene = new Scene(o, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();

				}
			});
			TextArea area = new TextArea();
			area.setPrefWidth(1000);
			area.setPrefHeight(500);

			passenger.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					BorderPane oo = new BorderPane();
					oo.setStyle("-fx-background-color: pink ;");
					GridPane gg = new GridPane();
					Label flnum = new Label("Flight Number");
					flnum.setFont(Font.font(15));
					flnum.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
					TextField t = new TextField();
					t.setMinHeight(35);
					t.setMinWidth(5);
					gg.add(flnum, 0, 0);
					gg.add(t, 1, 0);
					HBox h = new HBox();

					gg.setAlignment(Pos.CENTER);
					oo.setCenter(gg);
					btt.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							Label f = new Label("The Flight's Informations:");
							f.setFont(Font.font(15));
							f.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
							gg.add(f, 0, 10);
							m.chec();
							Node<Passengers> cur;
							Node<Flight> y = m.check(Integer.parseInt(t.getText()));
							cur = y.getF().p.head;
							if (y != null) {
								while (cur != null) {
									area.setFont(Font.font(15));
									area.setFont(Font.font(null, FontWeight.BOLD, area.getFont().getSize()));
									area.appendText(cur.getF().toString() + "\n");
									cur = cur.getNext();
								}
							}
							gg.add(area, 0, 15);
							gg.setAlignment(Pos.CENTER);
							oo.setCenter(gg);
						}

					});
					Image image2 = new Image("back.png");
					Button btt1 = new Button("", new ImageView(image2));
					btt1.setMinHeight(25);
					btt1.setMinWidth(25);
					h.getChildren().addAll(btt, btt1);
					h.setSpacing(30);
					h.setAlignment(Pos.CENTER);
					oo.setBottom(h);
					gg.setHgap(5);
					gg.setVgap(10);
					btt1.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							area.clear();
							primaryStage.setScene(scene1);

						}

					});

					Scene scene = new Scene(oo, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();
				}

			});
			add.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					BorderPane o = new BorderPane();
					o.setStyle("-fx-background-color: pink ;");
					GridPane g = new GridPane();
					Label flnum = new Label("Flight Number");
					flnum.setFont(Font.font(15));
					flnum.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
					TextField t = new TextField();
					t.setMinHeight(35);
					t.setMinWidth(5);
					g.add(flnum, 0, 0);
					g.add(t, 1, 0);
					btt.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							Node<Flight> x = m.check(Integer.parseInt(t.getText()));
							if (x != null) {
								Label b = new Label("Select one you want to update:");
								b.setFont(Font.font(15));
								b.setFont(Font.font(null, FontWeight.BOLD, b.getFont().getSize()));
								g.add(b, 0, 1);

								RadioButton flight = new RadioButton("Flight number");
								flight.setFont(Font.font(15));
								flight.setFont(Font.font(null, FontWeight.BOLD, flight.getFont().getSize()));
								g.add(flight, 0, 2);
								RadioButton air = new RadioButton("Airline Name");
								air.setFont(Font.font(15));
								air.setFont(Font.font(null, FontWeight.BOLD, air.getFont().getSize()));
								g.add(air, 0, 3);
								RadioButton sou = new RadioButton("Source");
								sou.setFont(Font.font(15));
								sou.setFont(Font.font(null, FontWeight.BOLD, sou.getFont().getSize()));
								g.add(sou, 0, 4);
								RadioButton des = new RadioButton("Destination");
								des.setFont(Font.font(15));
								des.setFont(Font.font(null, FontWeight.BOLD, des.getFont().getSize()));
								g.add(des, 0, 5);
								RadioButton cap = new RadioButton("Capcity");
								cap.setFont(Font.font(15));
								cap.setFont(Font.font(null, FontWeight.BOLD, cap.getFont().getSize()));
								g.add(cap, 0, 6);
								ToggleGroup qu = new ToggleGroup();
								flight.setToggleGroup(qu);
								air.setToggleGroup(qu);
								sou.setToggleGroup(qu);
								des.setToggleGroup(qu);
								cap.setToggleGroup(qu);
								flight.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										Label yy = new Label("Flight Number");
										yy.setFont(Font.font(15));
										yy.setFont(Font.font(null, FontWeight.BOLD, yy.getFont().getSize()));
										TextField y = new TextField();
										y.setMinHeight(35);
										y.setMinWidth(5);
										g.add(yy, 0, 7);
										g.add(y, 1, 7);
										btt.setOnAction(new EventHandler<ActionEvent>() {
											@Override
											public void handle(ActionEvent arg0) {
												x.getF().setFlightnumber(Integer.parseInt(y.getText()));
												m.checkk(x, Integer.parseInt(y.getText()));
												m.print();

											}

										});

									}

								});
								air.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										Label ys = new Label("Airline Number");
										ys.setFont(Font.font(15));
										ys.setFont(Font.font(null, FontWeight.BOLD, ys.getFont().getSize()));
										TextField y = new TextField();
										y.setMinHeight(35);
										y.setMinWidth(5);
										g.add(ys, 0, 8);
										g.add(y, 1, 8);
										btt.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												x.getF().setAirlinename(y.getText());
												m.print();

											}

										});

									}

								});
								sou.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										Label ys = new Label("Source");
										ys.setFont(Font.font(15));
										ys.setFont(Font.font(null, FontWeight.BOLD, ys.getFont().getSize()));
										TextField y = new TextField();
										y.setMinHeight(35);
										y.setMinWidth(5);
										g.add(ys, 0, 9);
										g.add(y, 1, 9);
										btt.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												x.getF().setSource(y.getText());
												m.print();

											}

										});

									}

								});
								des.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										Label ys = new Label("Destination");
										ys.setFont(Font.font(15));
										ys.setFont(Font.font(null, FontWeight.BOLD, ys.getFont().getSize()));
										TextField y = new TextField();
										y.setMinHeight(35);
										y.setMinWidth(5);
										g.add(ys, 0, 10);
										g.add(y, 1, 10);
										btt.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												x.getF().setDestination(y.getText());
												m.print();

											}

										});

									}

								});

								cap.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										Label ys = new Label("Capacity");
										ys.setFont(Font.font(15));
										ys.setFont(Font.font(null, FontWeight.BOLD, ys.getFont().getSize()));
										TextField y = new TextField();
										y.setMinHeight(35);
										y.setMinWidth(5);
										g.add(ys, 0, 11);
										g.add(y, 1, 11);
										btt.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												x.getF().setCapacity(Integer.parseInt(y.getText()));
												m.print();

											}

										});

									}

								});

							} else {
								Label flnum = new Label("Flight Number");
								flnum.setFont(Font.font(15));
								flnum.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
								TextField t = new TextField();
								t.setMinHeight(35);
								t.setMinWidth(5);
								g.add(flnum, 0, 0);
								g.add(t, 1, 0);
								Label airname = new Label("Airline Name");
								airname.setFont(Font.font(15));
								airname.setFont(Font.font(null, FontWeight.BOLD, airname.getFont().getSize()));
								TextField name = new TextField();
								name.setMinHeight(35);
								name.setMinWidth(5);
								g.add(airname, 0, 1);
								g.add(name, 1, 1);
								Label source = new Label("Source");
								source.setFont(Font.font(15));
								source.setFont(Font.font(null, FontWeight.BOLD, source.getFont().getSize()));
								TextField so = new TextField();
								so.setMinHeight(35);
								so.setMinWidth(5);
								g.add(source, 0, 2);
								g.add(so, 1, 2);
								Label des = new Label("Destination");
								des.setFont(Font.font(15));
								des.setFont(Font.font(null, FontWeight.BOLD, des.getFont().getSize()));
								TextField dess = new TextField();
								dess.setMinHeight(35);
								dess.setMinWidth(5);
								g.add(des, 0, 3);
								g.add(dess, 1, 3);
								Label cap = new Label("Capacity");
								cap.setFont(Font.font(15));
								cap.setFont(Font.font(null, FontWeight.BOLD, source.getFont().getSize()));
								TextField capp = new TextField();
								capp.setMinHeight(35);
								capp.setMinWidth(5);
								g.add(cap, 0, 4);
								g.add(capp, 1, 4);

								g.setAlignment(Pos.CENTER);
								o.setCenter(g);

								btt.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										Node<Flight> y = m.check(Integer.parseInt(t.getText()));
										if (y == null) {

											m.insert(new Flight(Integer.parseInt(t.getText()), name.getText(),
													so.getText(), dess.getText(), Integer.parseInt(capp.getText())));
											m.print();
										}
										g.setAlignment(Pos.CENTER);
										o.setCenter(g);
									}

								});

							}

						}

					});

					Image image2 = new Image("back.png");
					Button btt1 = new Button("", new ImageView(image2));
					g.setAlignment(Pos.CENTER);
					o.setCenter(g);
					btt1.setMinHeight(25);
					btt1.setMinWidth(25);
					HBox h = new HBox();
					h.getChildren().addAll(btt, btt1);
					h.setSpacing(30);
					h.setAlignment(Pos.CENTER);
					o.setBottom(h);
					btt1.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(scene1);

						}

					});
					g.setHgap(5);
					g.setVgap(20);
					Scene scene = new Scene(o, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();
				}

			});
			reserve.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					BorderPane o = new BorderPane();
					o.setStyle("-fx-background-color: pink ;");
					GridPane g = new GridPane();

					Label flnum = new Label("Flight Number");
					flnum.setFont(Font.font(15));
					flnum.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
					TextField t = new TextField();
					t.setMinHeight(35);
					t.setMinWidth(5);
					g.add(flnum, 0, 0);
					g.add(t, 1, 0);
					Label airname = new Label("Ticket number");
					airname.setFont(Font.font(15));
					airname.setFont(Font.font(null, FontWeight.BOLD, airname.getFont().getSize()));

					TextField name = new TextField();
					name.setMinHeight(35);
					name.setMinWidth(5);
					g.add(airname, 0, 1);
					g.add(name, 1, 1);
					Label source = new Label("Full name");
					TextField so = new TextField();
					source.setFont(Font.font(15));
					source.setFont(Font.font(null, FontWeight.BOLD, source.getFont().getSize()));
					so.setMinHeight(35);
					so.setMinWidth(5);

					g.add(source, 0, 2);
					g.add(so, 1, 2);
					Label des = new Label("Passport number");
					TextField dess = new TextField();
					des.setFont(Font.font(15));
					des.setFont(Font.font(null, FontWeight.BOLD, des.getFont().getSize()));
					dess.setMinHeight(35);
					dess.setMinWidth(5);
					g.add(des, 0, 3);
					g.add(dess, 1, 3);
					Label cap = new Label("Nationality");
					TextField capp = new TextField();
					cap.setFont(Font.font(15));
					cap.setFont(Font.font(null, FontWeight.BOLD, cap.getFont().getSize()));
					capp.setMinHeight(35);
					capp.setMinWidth(5);
					g.add(cap, 0, 4);
					g.add(capp, 1, 4);
					Label date = new Label("Date of Birth");
					TextField datee = new TextField();
					date.setFont(Font.font(15));
					date.setFont(Font.font(null, FontWeight.BOLD, date.getFont().getSize()));
					datee.setMinHeight(35);
					datee.setMinWidth(5);
					g.add(date, 0, 5);
					g.add(datee, 1, 5);
					g.setAlignment(Pos.CENTER);
					o.setCenter(g);

					btt.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							Node<Flight> y = m.check(Integer.parseInt(t.getText()));
							if (y != null) {

								try {
									y.getF().p.insert(new Passengers(Integer.parseInt(t.getText()), name.getText(),
											so.getText(), dess.getText(), capp.getText(), datee.getText()));
								} catch (NumberFormatException | ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}

						}

					});

					Image image33 = new Image("back.png");
					Button b2 = new Button("", new ImageView(image33));
					b2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(scene1);

						}

					});
					HBox h = new HBox();
					h.getChildren().addAll(btt, b2);
					h.setAlignment(Pos.CENTER);
					h.setSpacing(15);
					g.setHgap(5);
					g.setVgap(20);
					o.setBottom(h);

					Scene scene = new Scene(o, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();

				}

			});
			cancel.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					BorderPane o = new BorderPane();
					o.setStyle("-fx-background-color: pink ;");
					GridPane g = new GridPane();
					Label flnum = new Label("Flight Number");
					TextField t = new TextField();
					flnum.setFont(Font.font(15));
					flnum.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
					t.setMinHeight(35);
					t.setMinWidth(5);
					g.add(flnum, 0, 0);
					g.add(t, 1, 0);
					Label passp = new Label("Passenger Name");
					TextField pass = new TextField();
					passp.setFont(Font.font(15));
					passp.setFont(Font.font(null, FontWeight.BOLD, passp.getFont().getSize()));
					pass.setMinHeight(35);
					pass.setMinWidth(5);
					g.add(passp, 0, 1);
					g.add(pass, 1, 1);
					g.setAlignment(Pos.CENTER);
					o.setCenter(g);
					Image image22 = new Image("garbage.png");
					Button b1 = new Button("", new ImageView(image22));

					b1.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							int r = Integer.parseInt(t.getText());
							Node<Flight> x = m.check(r);

							if (x != null) {
								m.delete(pass.getText(), x);
								System.out.print("hi");
								// m.print1();
							} else {
								Label m = new Label("Message: ");
								TextField pp = new TextField();
								m.setFont(Font.font(15));
								m.setFont(Font.font(null, FontWeight.BOLD, m.getFont().getSize()));
								pp.setMinHeight(35);
								pp.setMinWidth(5);
								pp.setText("Couldn't find it");
								g.add(m, 0, 2);
								g.add(pp, 1, 2);
							}

						}

					});
					Image image33 = new Image("back.png");
					Button b2 = new Button("", new ImageView(image33));
					b2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(scene1);

						}

					});
					HBox h = new HBox();
					h.getChildren().addAll(b1, b2);
					h.setAlignment(Pos.CENTER);
					h.setSpacing(15);
					g.setHgap(5);
					g.setVgap(20);
					o.setBottom(h);

					Scene scene = new Scene(o, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();

				}

			});
			Exit.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					System.exit(0);
				}

			});
			search.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					BorderPane o = new BorderPane();
					o.setStyle("-fx-background-color: pink ;");
					GridPane g = new GridPane();
					Label tic = new Label("Passenger Full Name: ");
					tic.setFont(Font.font(15));
					tic.setFont(Font.font(null, FontWeight.BOLD, tic.getFont().getSize()));
					TextField t = new TextField();
					t.setMinHeight(35);
					t.setMinWidth(5);
					g.add(tic, 0, 0);
					g.add(t, 1, 0);
					btt.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							Node<Passengers> cur = m.reserved(t.getText());
							if (cur != null) {
								Label flnum = new Label("Flight Number");
								TextField t = new TextField();
								g.add(flnum, 0, 1);
								g.add(t, 1, 1);
								flnum.setFont(Font.font(15));
								flnum.setFont(Font.font(null, FontWeight.BOLD, flnum.getFont().getSize()));
								t.setMinHeight(35);
								t.setMinWidth(5);
								Label source = new Label("Ticket Number");
								TextField so = new TextField();
								g.add(source, 0, 2);
								g.add(so, 1, 2);
								source.setFont(Font.font(15));
								source.setFont(Font.font(null, FontWeight.BOLD, source.getFont().getSize()));
								so.setMinHeight(35);
								so.setMinWidth(5);
								Label des = new Label("Passport number");
								TextField dess = new TextField();
								g.add(des, 0, 3);
								g.add(dess, 1, 3);
								des.setFont(Font.font(15));
								des.setFont(Font.font(null, FontWeight.BOLD, des.getFont().getSize()));
								dess.setMinHeight(35);
								dess.setMinWidth(5);
								Label cap = new Label("Nationality");
								TextField capp = new TextField();
								g.add(cap, 0, 4);
								g.add(capp, 1, 4);
								cap.setFont(Font.font(15));
								cap.setFont(Font.font(null, FontWeight.BOLD, cap.getFont().getSize()));
								capp.setMinHeight(35);
								capp.setMinWidth(5);
								g.setAlignment(Pos.CENTER);
								o.setCenter(g);
								t.setText(String.valueOf(cur.getF().getFlightnumber()));
								so.setText(cur.getF().getTicketnumber());
								dess.setText(cur.getF().getPassportnumber());
								capp.setText(cur.getF().getNationality());
							}

						}

					});

					Image image33 = new Image("back.png");
					Button b2 = new Button("", new ImageView(image33));
					b2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(scene1);

						}

					});
					HBox h = new HBox();
					h.getChildren().addAll(btt, b2);
					h.setAlignment(Pos.CENTER);
					h.setSpacing(15);
					o.setBottom(h);
					g.setAlignment(Pos.CENTER);
					o.setCenter(g);
					g.setHgap(5);
					g.setVgap(20);
					Scene scene = new Scene(o, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();

				}

			});
			check.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					BorderPane o = new BorderPane();
					o.setStyle("-fx-background-color: pink ;");
					GridPane g = new GridPane();
					Label f = new Label("Flight Number:");
					f.setFont(Font.font(15));
					f.setFont(Font.font(null, FontWeight.BOLD, f.getFont().getSize()));
					TextField tt = new TextField();
					tt.setMinHeight(35);
					tt.setMinWidth(5);
					g.add(f, 0, 0);
					g.add(tt, 1, 0);
					Label pas = new Label("Passenger Full Name:");
					pas.setFont(Font.font(15));
					pas.setFont(Font.font(null, FontWeight.BOLD, pas.getFont().getSize()));
					TextField t = new TextField();
					t.setMinHeight(35);
					t.setMinWidth(5);
					g.add(pas, 0, 1);
					g.add(t, 1, 1);

					TextArea ar = new TextArea();
					ar.setPrefHeight(20);
					ar.setPrefWidth(20);
					btt.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							Node<Flight> curr = m.check(Integer.parseInt(tt.getText()));
							Node<Flight> cur = m.reserved(t.getText());
							if (curr != null && cur != null) {
								Label m = new Label("Message: ");
								TextField pp = new TextField();
								m.setFont(Font.font(15));
								m.setFont(Font.font(null, FontWeight.BOLD, m.getFont().getSize()));
								pp.setMinHeight(35);
								pp.setMinWidth(5);
								pp.setText("There is a reservation");
								g.add(m, 0, 2);
								g.add(pp, 1, 2);
							} else {
								Label m = new Label("Message: ");
								TextField pp = new TextField();
								m.setFont(Font.font(15));
								m.setFont(Font.font(null, FontWeight.BOLD, m.getFont().getSize()));
								pp.setMinHeight(35);
								pp.setMinWidth(5);
								pp.setText("Couldn't find it");
								g.add(m, 0, 2);
								g.add(pp, 1, 2);
							}
						}

					});
					Image image33 = new Image("back.png");
					Button b2 = new Button("", new ImageView(image33));
					b2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							primaryStage.setScene(scene1);

						}

					});
					HBox h = new HBox();
					h.getChildren().addAll(btt, b2);
					h.setAlignment(Pos.CENTER);
					h.setSpacing(15);
					o.setBottom(h);
					g.setAlignment(Pos.CENTER);
					g.setAlignment(Pos.CENTER);
					o.setCenter(g);
					g.setHgap(5);
					g.setVgap(20);
					Scene scene = new Scene(o, 1550, 800);
					primaryStage.setScene(scene);
					primaryStage.show();

				}

			});

			g.setAlignment(Pos.CENTER);
			root.setCenter(g);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
