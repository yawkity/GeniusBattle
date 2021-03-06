package test2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import backend.Analysis;

import com.mysql.jdbc.Statement;

public class MySQL {
	public static void connection(){     //establishes connection with mySQL driver
		try { 								
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static java.sql.Statement connectionToMySQL(){
		connection();
		String host = "jdbc:mysql://localhost/test";
		String username = "root";
		String password = "uukraine";
		try {
			Connection connect = DriverManager.getConnection(host, username, password);
			java.sql.Statement s = connect.createStatement();
			return s;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void insertSongInfo(Artist artist, Song song, Analysis an) throws IOException{
		java.sql.Statement s = connectionToMySQL();
		String sql = "INSERT INTO " + artist.getName().replace(' ', '_') + "_songs ( song_name, album_name, syllables_per_line, syllables_per_word, syllable_variation, novel_word_proportion, num_rhymes, rhymes_per_line, rhymes_per_syllable, rhyme_density, end_pairs_per_line, end_pairs_grown, end_pairs_shrunk, end_pairs_even, average_end_score, average_end_syll_score, singles_per_rhyme, doubles_per_rhyme, triples_per_rhyme, quads_per_rhyme, longs_per_rhyme, perfect_rhymes, line_internals_per_line, links_per_line, bridges_per_line, compounds_per_line, chaining_per_line, rap_genius_ratio)"
		+ " VALUES ( \""+ song.getCleanTitle(false)+ "\", \""+song.getAlbumName()+"\", "+an.getStat(0)+", "+an.getStat(1)+", "+an.getStat(2)+", "+an.getStat(3)+", "+an.getStat(4)+", "+an.getStat(5)+", "+an.getStat(6)+", "+an.getStat(7)+", "+an.getStat(8)+", "+an.getStat(9)+", "+an.getStat(10)+", "+an.getStat(11)+", "+an.getStat(12)+", "+an.getStat(13)+", "+an.getStat(14)+", "+an.getStat(15)+", "+an.getStat(16)+", "+an.getStat(17)+", "+an.getStat(18)+", "+an.getStat(19)+", "+an.getStat(20)+", "+an.getStat(21)+", "+an.getStat(22)+", "+an.getStat(23)+", "+ an.getStat(24)+", "+StringOps.getGeniusBattleScore(song)+");";
		System.out.println("just executed this: " + sql);
		try{
			s.executeUpdate(sql);
		} catch (SQLException x) {
			x.printStackTrace();
		}
	}
	
	
//	public static void insertAlbumInfo(Artist artist, Album album){ TODO create schema and make this insert proper data
//		java.sql.Statement s = connectionToMySQL();
//		String sql = "INSERT INTO " + artist.getName().replace(' ', '_') + "_songs ( album_name, syllables_per_line, syllables_per_word, syllable_variation, novel_word_proportion, num_rhymes, rhymes_per_line, rhymes_per_syllable, rhyme_density, end_pairs_per_line, end_pairs_grown, end_pairs_shrunk, end_pairs_even, average_end_score, average_end_syll_score, singles_per_rhyme, doubles_per_rhyme, triples_per_rhyme, quads_per_rhyme, longs_per_rhyme, perfect_rhymes, line_internals_per_line, links_per_line, bridges_per_line, compounds_per_line, chaining_per_line, rap_genius_ratio)"
//		+ " VALUES ( \""+ song.getCleanTitle(false)+ "\", \""+song.getAlbumName()+"\", "+an.getStat(0)+", "+an.getStat(1)+", "+an.getStat(2)+", "+an.getStat(3)+", "+an.getStat(4)+", "+an.getStat(5)+", "+an.getStat(6)+", "+an.getStat(7)+", "+an.getStat(8)+", "+an.getStat(9)+", "+an.getStat(10)+", "+an.getStat(11)+", "+an.getStat(12)+", "+an.getStat(13)+", "+an.getStat(14)+", "+an.getStat(15)+", "+an.getStat(16)+", "+an.getStat(17)+", "+an.getStat(18)+", "+an.getStat(19)+", "+an.getStat(20)+", "+an.getStat(21)+", "+an.getStat(22)+", "+an.getStat(23)+", "+ an.getStat(24)+", "+StringOps.getGeniusBattleScore(song)+");";
//		System.out.println(sql);
//		s.executeUpdate(sql);
//	}
}
