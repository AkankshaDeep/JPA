package com.cognizant.movie.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movie;
import com.cognizant.movie.repository.FavoriteRepository;
import com.cognizant.movie.repository.MovieRepository;


@Controller
public class MovieController {
	
	@Autowired
	MovieRepository movierepo;
	@Autowired
	FavoriteRepository favrepo;
	@RequestMapping("/movie-list-admin")
	public String showMovies(ModelMap map) throws ParseException
	{
		
		/*Movie m=new Movie();
		m.setId(5L);
		m.setActive("No");
		m.setBoxOffice("$1,671,713,208");
		m.setGenre("Science Fiction");
		m.setHasTeaser("Yes");
		m.setTitle("Jurassic World");
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse("02/07/2017");
		m.setDateOfLaunch(date1);
		movierepo.save(m);
		*/
		List<Movie> l=(List<Movie>) movierepo.findAll();
		map.put("movielist", l); 
		return "movie-list-admin";
	}
	
	
	@RequestMapping("/edit-movie")
	public String EditMenuItemListAdmin(ModelMap model,@RequestParam Long id) {
		System.out.println("hello "+id);
		List<Movie> movie=(List<Movie>) movierepo.findAll();
		 Movie men=new Movie();
		 for(Movie m:movie)
		 {
			 if(m.getId()==id)
			 {
				 men.setId(id);
				 men.setBoxOffice(m.getBoxOffice());
				 men.setActive(m.isActive());
				 men.setDateOfLaunch(m.getDateOfLaunch());
				 men.setHasTeaser(m.isHasTeaser());
				 men.setGenre(m.getGenre());
				 men.setTitle(m.getTitle());
			 }
		 }
			model.put("movie",men);
			
			
		return "edit-movie";
		
	}
	
	@RequestMapping("edit-movie-status")
	public String updaeStatus(ModelMap map,@RequestParam Long id,@RequestParam String title,@RequestParam String boxOffice,
			@RequestParam String active,@RequestParam String dateOfLaunch,
			@RequestParam String genre,@RequestParam(defaultValue = "false") String hasTeaser) throws ParseException
	{
		System.out.println(id+" "+title+" "+boxOffice+" "+active+" "+dateOfLaunch+" "+genre+" "+hasTeaser);
		
		Movie m=new Movie();
		m.setId(id);
		m.setTitle(title);
		boxOffice="$ "+boxOffice;
		m.setBoxOffice(boxOffice);
		m.setActive(active);
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateOfLaunch);
		m.setDateOfLaunch(date1);
		m.setGenre(genre);
		if(hasTeaser.equals("on"))
			hasTeaser="Yes";
		else 
			hasTeaser="No";
		m.setHasTeaser(hasTeaser);
		movierepo.save(m);
		  List<Movie> mov=(List<Movie>)movierepo.findAll();
			map.put("menulist",mov);
		return "edit-movie-status";
	}
	
	
	@RequestMapping("/movie-list-customer")
	public String favoriteList(ModelMap map)
	{
		
		List<Movie> l=(List<Movie>) movierepo.findAll();
		List<Movie> customer=new ArrayList<>();
		for(Movie m:l)
		{
			if(m.isActive().equals("Yes"))
			{
				Movie mov=new Movie();
				mov.setId(m.getId());
				mov.setTitle(m.getTitle());
				mov.setActive(m.isActive());
				mov.setBoxOffice(m.getBoxOffice());
				mov.setDateOfLaunch(m.getDateOfLaunch());
				mov.setGenre(m.getGenre());
				mov.setHasTeaser(m.isHasTeaser());
				customer.add(mov);
			}
		}
		
		map.put("customerlist",customer);
		
		
		return "movie-list-customer";
	}
	
	@RequestMapping("/movie-list-customer-notification")
	public String FavoriteNotification(ModelMap map,@RequestParam Long id)
	{
		System.out.println(id);
		List<Movie> movie=(List<Movie>) movierepo.findAll();
		 Favorites men=new Favorites();
		 for(Movie m:movie)
		 {
			 if(m.getId()==id)
			 {
				 men.setId(id);
				 men.setTitle(m.getTitle());
				 men.setGenre(m.getGenre());
				 men.setBoxOffice(m.getBoxOffice());
				 
			 }
		 }
		 favrepo.save(men);
		 

			List<Movie> l=(List<Movie>) movierepo.findAll();
			List<Movie> customer=new ArrayList<>();
			for(Movie m:l)
			{
				if(m.isActive().equals("Yes"))
				{
					Movie mov=new Movie();
					mov.setId(m.getId());
					mov.setTitle(m.getTitle());
					mov.setActive(m.isActive());
					mov.setBoxOffice(m.getBoxOffice());
					mov.setDateOfLaunch(m.getDateOfLaunch());
					mov.setGenre(m.getGenre());
					mov.setHasTeaser(m.isHasTeaser());
					customer.add(mov);
				}
			}
			
			map.put("customerlist",customer);
			
			
		 
		return "movie-list-customer-notification";
	}
	
	@RequestMapping("/favorites")
	public String Favorite(ModelMap map)
	{
		List<Favorites> fav=(List<Favorites>) favrepo.findAll();
		if(fav.size()>0)
		{
			map.put("favorites",fav);
			
		return "favorites";
		}
		else
		{
			return "favorites-empty";
		}
	}

	
	
	@RequestMapping("/favorites-notification")
	public String FavoriteNoti(ModelMap map,@RequestParam Long id)
	{
		favrepo.deleteById(id);
		List<Favorites> fav=(List<Favorites>) favrepo.findAll();
		if(fav.size()>0)
		{map.put("favorites",fav);
		return "favorites-notification";}
		else
		{
			return "favorites-empty";
		}
	}
	
}
