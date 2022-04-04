package vttp2022paf.day1.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022paf.day1.models.Comment;
import vttp2022paf.day1.models.Game;
import vttp2022paf.day1.repositories.GameRepositary;

@Controller
@RequestMapping(path="/game")
public class GameController {

    @Autowired
	private GameRepositary gameRepo;

    @GetMapping(path="/{gid}")
    public String display(@PathVariable(name="gid") Integer gid,
        Model model){
            
            Game game = new Game();

            game = gameRepo.getGameByGid(gid).orElse(null);
            List<Comment> comment = new LinkedList<>();
            comment = gameRepo.getCommentsByGid(gid);

            model.addAttribute("game",game);
            model.addAttribute("comment",comment);

        return "game";
    }

    
}
