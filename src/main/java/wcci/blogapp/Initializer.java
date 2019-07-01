package wcci.blogapp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.blogapp.models.Author;
import wcci.blogapp.models.Genre;
import wcci.blogapp.models.Post;
import wcci.blogapp.models.PostTag;
import wcci.blogapp.repositories.AuthorRepository;
import wcci.blogapp.repositories.GenreRepository;
import wcci.blogapp.repositories.PostRepository;
import wcci.blogapp.repositories.PostTagRepository;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private GenreRepository genreRepo;

	@Autowired
	private AuthorRepository authorRepo;

	@Autowired
	private PostTagRepository postTagRepo;
	
	Author dallas = new Author("Dallas McKay");
	Author jon = new Author("Jon Davis");
	Author chris = new Author("Christopher Huddleston");
	
	Genre military = new Genre("For Military");
	Genre family = new Genre("For Family");
	Genre citizens = new Genre("For Citizens");
	
	PostTag multiple = new PostTag("Multiple Deployments");
	PostTag general = new PostTag("General");
	PostTag home = new PostTag("First Coming Home");
	PostTag ptsd = new PostTag("PTSD");

	Post post1 = new Post("Home After War", "It is one of the least understood dichotomies of military life. Even among soldiers. The fact of the matter is, it is awesome until it isn't.\n" + 
			"\n" + 
			"Let me say that again:\n" + 
			"\n" + 
			"It is awesome…until it isnt.\n" + 
			"\n" + 
			"War time is hard on marriage and family in general. In the civilian sector, you rarely see situations where a parent or spouse is out of the house and unable to contact home for more than a few weeks at a time. Even divorced parents live relatively close to their children and can have an active role in their kids lives. Changes are never drastic.\n" + 
			"\n" + 
			"For the soldier, they will see year long deployments to places where communication with home is degraded and even impossible for long periods. Add to that the possibility of severe harm coming to the soldier, there is stress of an unbelievable level on families.\n" + 
			"\n" + 
			"While a soldier is gone, even if they are sent to an area of relative safety and easy communication, there are changes. People are constantly changing in every walk of life. But those changes are small, and the people who are in their lives on a daily basis change with them and adapt to these subtle adjustments without noticing what happened. Take a person out of that relationship for a year and you don't have that give and take of adjustment.\n" + 
			"\n" + 
			"And many times, the changes are a lot more drastic than they would have been. A soldier sees combat, it takes its toll, their world view is different all of a sudden. The spouse at hone has suddenly become a head of household and/or a single parent. A young person is literally on their own for the first time. A child who was just beginning to for concrete memories knows there is a mommy or daddy somewhere, but the concept of that person and their meaning is abstract at best. A new normal forms for each member of the family. When the soldier comes home, those changes are sudden and drastic.\n" + 
			"\n" + 
			"Your wife or husband looks very different. Even VTC and pictures don't capture the changes. I guess we edit in our mind. The house looks different. Things aren't where they used to be. You forget you own stuff (I forgot I owned a very large motorcycle.) Kids have grown, and they have developed into people that are vastly different than whom you said goodbye to. Sometimes, younger children are scared of Thier parents; they are strangers to them.\n" + 
			"\n" + 
			"The is so much euphoria at the reunion. That lasts for a while as you take vacation. After that, it is a lot of hard work and education on what the dynamics of your family life is. This is the “…until it's not” phase.\n" + 
			"\n" + 
			"A lot of families can't handle it. Things happened while soldier was away. Sometimes they are the cliché events of infadelity. Sometimes it is the growth of one partner and the shrinking of another. Sometimes the stress and trauma of going to war leaves a person angry and depressed. Sometimes, the changes I mentioned above are too many to overcome. And a great deal of families work through it and become stronger.\n" + 
			"\n" + 
			"The services do a great job helping families cope from beginning to end. There are countless resources for before, during and after the deployment. Their success is really based on how much effort the families put into it. The important thing is that it is there.\n" + 
			"\n" + 
			"Again, it is awesome until it is not. But what I failed to mention is, if you can get through the “not,” it will be awesome again.", military, LocalDateTime.now());
	
	
	Post post2 = new Post("Home From Combat Deployment", "It is an experience that is incredibly difficult to understand and describe. I don't know if your question is directed to military people in general. Perhaps someone else can answer what it is like to come home wounded physically or mentally.\n" + 
			"\n" + 
			"I will try to describe the emotional/psychological process that I and many other fellow Marines (soldiers, sailors, ext.) experienced.\n" + 
			"\n" + 
			"Before you understand what a returning Marine/soldier/sailor/ext experiences when they come home you have to know what they really go through when they are over there.\n" + 
			"\n" + 
			"What we all experience, combat or none, is a very, very long period of extended absence from comfort, security, our families, and breaks. The Marines spend seven months on deployment. Army is about twice that, but they don't go as often. That means months where you deal with the same people day, after day, after day. There is no change and no break. You work with them, you eat with them, and you live with them. If you can't stand them, oh well. If your boss is a jerk or psycho, there isn't even the escape of going home at the end of the day or having a weekend. Now you need to consider the war side of things. In the best case scenario, you are under the constant threat of surprise attack. Car bombs, roadside bombs, suicide bombers, mortars. Looking at people everywhere who you can see absolutely hate you. In the worst case you actually fight. You might kill people. You might lose friends. But I won't get into what it's like for those cases, they are pretty tough to nail down and can vary wildly. But whatever picture I drew, don't think about how it sucks for a few short periods of intense violence; imagine it sucking for months and months of a slow drone and a psychological beating.\n" + 
			"\n" + 
			"And then you come home. Everything is fine now right? Not really...\n" + 
			"\n" + 
			"First, we are absolutely elated to come home, see our families, go to our bars, women... This is a high that can't really be expressed very accurately. In a way you are doing things that you have done many times before, but it has been so long that it feels completely foreign to you. When you see your wife, she is unfamiliar to you. When you first see her, you get the smell of her hair and her embrace, but there are subtle differences that make you feel as if things are different somehow. Her hair has changed or she has new interests. It kind of feels like a first date for a few weeks as you try to remember how you fit together again...figuratively speaking. This \"second first date\" is the same with all the things you do, hanging out with your old friends, going to favorite hangouts. But don't get me wrong. Even if we are quiet about it and act like it is no big deal, these are some of the happiest days we have ever had.\n" + 
			"\n" + 
			"Second, there is residual stress that carries over from a combat deployment. While on deployment, military people deal with each other in ways that are not normal in civilian America. We are harsh with each other and don't often act with kindness and gentleness with one another. Add this to natural combat stress, the constant concern that you may get attacked, the wondering if a vehicle near you is going to blow up, always seeing in the eye of every local that they want to kill you. You are suspicious, tightly wound, and easily angered. I remember several times waking up in my bed even a few months after deployment and panicking because I couldn't find my weapon. You also don't mesh well with your families. They do things you don't understand. They do things you don't understand, mostly because they have grown very independent of you. Many confuse this for a feeling that you are unwanted or unneeded, and this makes the returning person very irritable. Combine all these and you have an explanation as to why so many men returning from \"over there\" come back angry and beat their wives. It is difficult to transition between two worlds and some, especially those who experience combat, don't cope well. It isn't right, but it happens.\n" + 
			"\n" + 
			"Third, there is a long phase where you try to adjust to having your life back. To be honest, it is never the same as before you left. You are changed by the experience of a combat deployment, even after the first. Every time you go, you change. And so does everyone else that you care about. Everyone matures naturally, but independent of each other, and you have to reintegrate into each other's lives again. Young Marines often have a hard time keeping control; husbands fight with wives, and fathers can't communicate with kids (and don't be naive, this is different from those people who think it is the same as having teenagers). It takes time before everything settles down emotionally. Most people make it through this phase OK, but unfortunately, many don't.\n" + 
			"\n" + 
			"This is the part of coming home most people don't really talk about.", military, LocalDateTime.now());
	
	
	Post post3 = new Post("Home From Combat Deployment", "The situation dictates really. When I was in the US Marines, I was in combat almost everyday. Then you have the military personnel that never leave their base that has plumbing and air conditioning. So I really can't say what it would be like for those kind of people because I was never one of them. I think that I can at least speak on behalf of the veterans that have seen combat. \n" + 
			"\n" + 
			"I slept on the ground, with no Internet, no showers or a warm meal for most of my whole deployment to Iraq and Afghanistan. I swept for mines and IEDs clearing the way before some of the most badass people such as Navy SEALS and Marine Recon would enter the area so that they can do their job. \n" + 
			"\n" + 
			"When I got home everything changed. You missed out on months of life back home and have no idea where the time has passed. Your kids are older, your wife acts different, your friends look at you differently, but it's all because the veteran has changed. Having no connection to the world; no news, no tv, no magazines, you are in kind of a shock to see that so much has changed and that you feel like you lost out on it.\n" + 
			"\n" + 
			" Your mind is still in combat mode. You constantly are on watch and get startled easily and all you think about is the things you saw. For both of my tours I had a panic attack when I finally got back home. You feel like you don't know what to do. You are confused about how to act and talk. And you know that nobody is going to understand what you did. \n" + 
			"\n" + 
			"These are obvious signs of PTSD. The first thing I did when I got home is go to therapy, which in my opinion every Vet should do. It is extremely helpful and there are so many resources for vets in need. And as long as you talk through it about what happened you will be able to control your PTSD. It is not curable, but it is possible to suppress it and that is what I have done. I am happier now than I have ever been and I am comfortable with talking about my experiences. \n" + 
			"\n" + 
			"I feel like I should say this because most military personnel wouldn't. They are too \"strong and manly\" to talk about their feelings! \n" + 
			"\n" + 
			"I don't expect people to understand what those men and women do over there or why they do it. I tried my best to explain what goes on when veterans come home, but some things you just can't put into words.", military, LocalDateTime.now());


	@Override
	public void run(String... args) throws Exception {	
		
		authorRepo.save(dallas);
		authorRepo.save(jon);
		authorRepo.save(chris);
		
		genreRepo.save(military);
		genreRepo.save(family);
		genreRepo.save(citizens);
		
		postTagRepo.save(multiple);
		postTagRepo.save(general);
		postTagRepo.save(home);
		postTagRepo.save(ptsd);
		
		postRepo.save(post1);
		postRepo.save(post2);
		postRepo.save(post3);
		
		dallas.addPost(post1);
		authorRepo.save(dallas);
		
		jon.addPost(post2);
		authorRepo.save(jon);
		
		chris.addPost(post3);
		authorRepo.save(chris);
		
		home.addPost(post1);
		home.addPost(post2);
		home.addPost(post3);
		postTagRepo.save(home);
		
		general.addPost(post1);
		general.addPost(post2);
		postTagRepo.save(general);
		
		ptsd.addPost(post3);
		postTagRepo.save(ptsd);
	}
}
