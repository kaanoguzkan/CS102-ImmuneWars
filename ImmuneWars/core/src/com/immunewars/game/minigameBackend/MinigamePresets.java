package com.immunewars.game.minigameBackend;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public abstract class MinigamePresets {

	public abstract static class TicTacToe {
		public static int gameSize = 3;
		public static int winLength = 3;
	}
	
	public abstract static class SpaceInvaders {
		public static int xBound = 1280;
		public static int yBound = 800;
		public static int startHealth = 5;
		public static String bulletTexture = "bullet.png";
		public static String bulletTextureFlipped = "bulletFlipped.png";
		public static String enemyTexture = "enemy.png";
		public static String shipTexture = "ship.png";
	}

	public abstract static class Snake {
		public static int xBound = 1280;
		public static int yBound = 800;
		public final static int PIXEL_SIZE = 80;
        public static String snakeHeadTexture ="1.jpg"; // didnt work.
	}

    public abstract static class ImageMatching{
        public static String backOfCard = "1.png";
        public final int X_BOUND = 1280;
        public final int Y_BOUND = 800;
        public final static int DEFAULT_OPTION = 3;

        public static String[] images = {
            "IM_1.png", "IM_2.png", "IM_3.png",
            "IM_4.png", "IM_5.png", "IM_6.png",
            "IM_7.png", "IM_8.png", "IM_9.png"
        };
		
		/*		for(anImage element: images){
			if(element.getID() == currImageID1 || element.getID() == currImageID2){
				element.draw(spriteBatch);
			}
		}
		 * 	public ImageMatchingScreen(ImmuneWars game, int gameSize){
		ImageMatching backEnd = new ImageMatching(game, gameSize);
		count = 0;
		currentScreen = this;
		this.game = game;
		
		this.gameSize = gameSize;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, gameScreenX, gameScreenY);
		viewport = new StretchViewport(gameScreenX, gameScreenY, camera);
		viewport.apply();
		
		stage = new Stage();
		stage.setViewport(viewport);
		Gdx.input.setInputProcessor(stage);

		backgroundTexture = new Texture("title screen.png");
        backgroundSprite =new Sprite(backgroundTexture);
        backgroundSprite.setBounds(100, 100, 200, 200);
		
		lineThickness = Math.max(Math.min(40 / (gameSize + 1), 10), 5);
		buttonLengthX = ((float)(gameScreenX - lineThickness)/gameSize - lineThickness);
		buttonLengthY = ((float)(gameScreenY - lineThickness)/gameSize - lineThickness);
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				anImage button = new anImage(new TextureRegionDrawable(new Texture("badlogic.jpg")), count / 2);

				button.setX(lineThickness + i*(buttonLengthX + lineThickness));
				button.setY(lineThickness + j*(buttonLengthY + lineThickness));
				button.setSize(buttonLengthX, buttonLengthY);
				button.setColor(new Color(1.0f,1.0f,1.0f,1.0f));
					
				button.addListener(new ClickListener() {
				@Override
				public void clicked (InputEvent event, float x, float y) {
					float tempX = button.getX();
					float tempY = button.getY();
					button.remove();
					anImage button = new anImage(new TextureRegionDrawable(new Texture(imagePaths[count++])), count / 2);
					System.out.println("---------");
					button.setX(tempX);
					button.setY(tempY);
					System.out.println(tempY + " " + tempX);
				}
			});

			stage.addActor(button);
			}
		}
		 */
    }


	public abstract static class SpeedTyping
	{ //when x bound 1280, the limit is 21 letters
		public static final int BOX_WIDTH = 50;
		public static final int BOX_HEIGHT = 100;

		public static final String[] wordList = 
		{
			"Cell",
			"DNA",
			"Gene",
			"Protein",
			"Enzyme",
			"Mitochondria",
			"Chloroplast",
			"Nucleus",
			"Cytoplasm",
			"Ribosome",
			"Photosynthesis",
			"Respiration",
			"Mitosis",
			"Meiosis",
			"Evolution",
			"Natural selection",
			"Mutation",
			"Adaptation",
			"Ecosystem",
			"Food chain",
			"Trophic level",
			"Biodiversity",
			"Biome",
			"Community",
			"Population",
			"Habitat",
			"Niche",
			"Species",
			"Kingdom",
			"Phylum",
			"Class",
			"Order",
			"Family",
			"Genus",
			"Species",
			"Taxonomy",
			"Bacteria",
			"Virus",
			"Fungi",
			"Protist",
			"Archaea",
			"Prokaryote",
			"Eukaryote",
			"Cell membrane",
			"Cell wall",
			"Organelle",
			"Endoplasmic reticulum",
			"Golgi apparatus",
			"Lysosome",
			"Vacuole",
			"Cytoskeleton",
			"Diffusion",
			"Osmosis",
			"Active transport",
			"Passive transport",
			"ATP",
			"Fermentation",
			"pH",
			"Acid",
			"Base",
			"Carbon cycle",
			"Nitrogen cycle",
			"Water cycle",
			"Chlorophyll",
			"Carbohydrate",
			"Lipid",
			"Protein",
			"Nucleic acid",
			"RNA",
			"Messenger RNA",
			"Transfer RNA",
			"Ribosomal RNA",
			"DNA replication",
			"Transcription",
			"Translation",
			"Codon",
			"Anticodon",
			"Allele",
			"Dominant",
			"Recessive",
			"Homozygous",
			"Heterozygous",
			"Phenotype",
			"Genotype",
			"Mendelian inheritance",
			"Punnett square",
			"Pedigree",
			"Mutation",
			"Genetic engineering",
			"Cloning",
			"Biotechnology",
			"Stem cell",
			"Ecology",
			"Parasitism",
			"Mutualism",
			"Commensalism",
			"Symbiosis",
			"Homeostasis",
			"Antigen",
			"Antibody",
			"Immune system",
			"Immunity",
			"Innate immunity",
			"Adaptive immunity",
			"Cytokines",
			"Inflammation",
			"Phagocytosis",
			"Complement system",
			"Autoimmune disease",
			"Allergy",
			"Immunodeficiency",
			"Histamine",
			"Humoral immunity",
			"Interferons",
			"Natural killer cells",
			"Helper T cells",
			"Cytotoxic T cells",
			"Regulatory T cells",
			"Opsonization",
			"Memory B cells",
			"Memory T cells",
			"Granulocytes",
			"Mast cells",
			"Dendritic cells",
			"Phagosome",
			"Acquired immunity",
			"Immunosuppression",
			"Psoriasis"
		};

		public static final String[] wordDefinitions = {
			"The basic structural and functional unit of all living organisms.",
			"Deoxyribonucleic acid, a molecule that carries genetic instructions for the development, functioning, growth, and reproduction of organisms.",
			"A unit of heredity that is transferred from a parent to offspring and is held to determine some characteristic of the offspring.",
			"Large molecules composed of amino acids which perform a variety of functions in living organisms, including providing structure and catalyzing chemical reactions.",
			"A type of protein that acts as a catalyst, speeding up chemical reactions in living organisms.",
			"Organelles responsible for generating energy in the form of ATP through cellular respiration.",
			"Organelles found in plant cells responsible for photosynthesis, where light energy is converted into chemical energy.",
			"A membrane-bound organelle that contains the cell's DNA and serves as the control center of the cell.",
			"The gel-like substance that fills the cell and surrounds organelles.",
			"Cellular structures where proteins are synthesized.",
			"The process by which green plants and some other organisms use sunlight to synthesize foods with the help of chlorophyll.",
			"The process by which cells break down organic molecules to produce energy (ATP).",
			"Cell division that results in two identical daughter cells, used for growth, repair, and asexual reproduction.",
			"Cell division that results in four daughter cells with half the number of chromosomes as the parent cell, used for sexual reproduction.",
			"The process of change in the inherited characteristics of biological populations over successive generations.",
			"The process by which organisms better adapted to their environment tend to survive and reproduce more effectively.",
			"A change in the DNA sequence that may alter the genetic information and can lead to variation in organisms.",
			"A characteristic that helps an organism survive and reproduce in its environment.",
			"A community of organisms interacting with each other and with their physical environment.",
			"A series of organisms each dependent on the next as a source of food.",
			"Each step in a food chain or food web where energy and nutrients are transferred.",
			"The variety of life forms in an ecosystem or biome.",
			"A large naturally occurring community of flora and fauna occupying a major habitat.",
			"All the populations of different species that live and interact in a particular area.",
			"A group of organisms of the same species living in the same area.",
			"The natural environment in which an organism lives.",
			"The role or function of an organism within an ecosystem.",
			"A group of organisms capable of interbreeding and producing fertile offspring.",
			"One of the highest ranks in the biological classification of organisms.",
			"A taxonomic rank below kingdom and above class in biological classification.",
			"A taxonomic rank below phylum and above order in biological classification.",
			"A taxonomic rank below class and above family in biological classification.",
			"A taxonomic rank below order and above genus in biological classification.",
			"A taxonomic rank below family and above species in biological classification.",
			"A group of organisms capable of interbreeding and producing fertile offspring.",
			"The science of naming and classifying organisms.",
			"Single-celled microorganisms that can be found in various environments.",
			"A small infectious agent that can only replicate inside the cells of other organisms.",
			"A group of organisms including yeasts, molds, and mushrooms that obtain nutrients by decomposing organic matter.",
			"A diverse group of eukaryotic microorganisms.",
			"Single-celled microorganisms similar to bacteria but with distinct molecular characteristics.",
			"A single-celled organism that lacks a nucleus and other membrane-bound organelles.",
			"An organism with cells that have a nucleus and other membrane-bound organelles.",
			"The semipermeable membrane surrounding the cytoplasm of a cell.",
			"A rigid layer surrounding the cell membrane of plants, fungi, and some bacteria.",
			"Specialized structures within a cell that perform specific functions.",
			"A network of membranes within the cytoplasm of eukaryotic cells involved in protein and lipid synthesis.",
			"An organelle responsible for modifying, sorting, and packaging proteins and lipids for transport.",
			"An organelle containing digestive enzymes, responsible for breaking down waste materials and cellular debris.",
			"A membrane-bound organelle found in plant and fungal cells that stores water and nutrients.",
			"A network of protein filaments within cells that provides structural support and facilitates cell movement.",
			"The movement of molecules from an area of high concentration to an area of low concentration.",
			"The diffusion of water across a selectively permeable membrane.",
			"The movement of molecules across a cell membrane against the concentration gradient, requiring energy.",
			"The movement of molecules across a cell membrane without the input of energy.",
			"The primary energy currency of cells.",
			"The process by which cells release energy in the absence of oxygen.",
			"A measure of the acidity or alkalinity of a solution.",
			"A substance that donates hydrogen ions in solution.",
			"A substance that accepts hydrogen ions in solution.",
			"The cycle by which carbon is exchanged between the biosphere, geosphere, hydrosphere, and atmosphere.",
			"The cycle by which nitrogen is converted between its various chemical forms.",
			"The continuous movement of water on, above, and below the surface of the Earth.",
			"The green pigment found in chloroplasts that is essential for photosynthesis.",
			"Organic compounds made up of carbon, hydrogen, and oxygen atoms, including sugars, starches, and cellulose.",
			"Compounds that are insoluble in water, including fats, oils, and phospholipids.",
			"Large molecules composed of amino acids which perform a variety of functions in living organisms, including providing structure, regulating cellular processes, and catalyzing biochemical reactions.",
			"Biomolecules, including DNA and RNA, that carry genetic information and are essential for the functioning and reproduction of cells.",
			"Ribonucleic acid, a nucleic acid molecule that plays a crucial role in protein synthesis and gene expression.",
			"RNA molecules that carry genetic information from the DNA to the ribosome for protein synthesis.",
			"RNA molecules that transport amino acids to the ribosome during protein synthesis.",
			"RNA molecules that, along with proteins, make up the ribosome, the cellular structure where protein synthesis occurs.",
			"The process by which DNA is copied to produce identical DNA molecules.",
			"The process by which the information encoded in DNA is copied into RNA.",
			"The process by which the genetic information carried by mRNA is used to synthesize proteins.",
			"A sequence of three nucleotides in mRNA that corresponds to a specific amino acid or stop signal during protein synthesis.",
			"A sequence of three nucleotides in tRNA that complementary base pairs with a codon in mRNA during translation.",
			"One of the possible forms of a gene, differing from other alleles by one or a few nucleotides.",
			"A genetic trait that is expressed when an individual has at least one copy of the dominant allele.",
			"A genetic trait that is expressed only when an individual has two copies of the recessive allele.",
			"Having two identical alleles for a particular gene.",
			"Having two different alleles for a particular gene.",
			"The observable physical or biochemical characteristics of an organism, determined by its genotype and influenced by environmental factors.",
			"The genetic makeup of an organism, determined by the combination of alleles it possesses.",
			"The principles of inheritance described by Gregor Mendel, including the law of segregation and the law of independent assortment.",
			"A graphical representation used to predict the possible genotypes of offspring in a genetic cross.",
			"A diagram showing the genetic relationships among individuals in a family over multiple generations.",
			"A change in the DNA sequence that can result in altered traits or genetic disorders.",
			"The manipulation of an organism's genetic material to produce desired traits or characteristics.",
			"The process of producing genetically identical copies of a cell or organism.",
			"The application of biological knowledge and techniques to develop products and processes for human benefit.",
			"A type of undifferentiated cell with the ability to differentiate into specialized cell types.",
			"The study of the interactions between organisms and their environment.",
			"A symbiotic relationship in which one organism benefits at the expense of another organism.",
			"A symbiotic relationship in which both organisms benefit from the interaction.",
			"A symbiotic relationship in which one organism benefits and the other is neither helped nor harmed.",
			"Any interaction between two different organisms living in close physical association, typically to the advantage of both.",
			"The ability of an organism or system to maintain internal stability and balance, despite external changes.",
			"A molecule that triggers an immune response in the body, typically by being recognized as foreign. Antigens can be proteins, carbohydrates, or other molecules present on the surface of pathogens or foreign substances.",
			"Proteins produced by the immune system in response to the presence of specific antigens. Antibodies bind to antigens and mark them for destruction by other immune cells. They play a crucial role in the body's defense against pathogens and in the immune response to infections.",
			"The body's defense system against infectious agents, toxins, and other foreign substances. It includes various organs, cells, and molecules that work together to recognize and eliminate pathogens while distinguishing them from the body's own cells.",
			"The ability of an organism to resist or prevent infection and disease through the action of the immune system.",
			"The nonspecific defense mechanisms that act as the first line of defense against pathogens, including physical barriers, phagocytic cells, and inflammation. Innate immunity provides immediate protection but lacks specificity.",
			"The specific immune response that develops after exposure to a pathogen and provides long-term protection. It involves the activation of lymphocytes (T cells and B cells) and the production of antibodies.",
			"Signaling molecules secreted by immune cells that regulate the immune response, including inflammation, cell proliferation, and differentiation.",
			"A localized response to tissue injury or infection characterized by redness, swelling, heat, and pain. Inflammation helps to eliminate pathogens and initiate tissue repair.",
			"The process by which certain cells (such as macrophages and neutrophils) engulf and digest foreign particles, such as bacteria and dead cells.",
			"A group of proteins in the blood that work together to enhance the immune response against pathogens. Complement proteins can directly kill pathogens, opsonize them for phagocytosis, and stimulate inflammation.",
			"A condition in which the immune system mistakenly attacks the body's own tissues, leading to inflammation and tissue damage. Examples include rheumatoid arthritis, lupus, and multiple sclerosis.",
			"An exaggerated immune response to a harmless substance (allergen) that triggers inflammation and other symptoms, such as itching, sneezing, and swelling.",
			"A condition in which the immune system is impaired or weakened, making individuals more susceptible to infections. It can be congenital or acquired, as seen in HIV/AIDS.",
			"A chemical released by mast cells and basophils during an allergic reaction or inflammation. Histamine causes blood vessels to dilate and become more permeable, leading to the characteristic symptoms of allergy.",
			"The aspect of the adaptive immune response mediated by antibodies, which circulate in the blood and lymphatic system, neutralizing pathogens and marking them for destruction.",
			"Proteins produced by cells in response to viral infections or other stimuli. Interferons play a key role in activating immune cells and inhibiting viral replication.",
			"A type of cytotoxic lymphocyte that plays a critical role in the innate immune response against infected or cancerous cells. NK cells can directly kill target cells without prior sensitization.",
			"T lymphocytes that coordinate the immune response by releasing cytokines and activating other immune cells, including B cells and cytotoxic T cells.",
			"T lymphocytes that directly kill infected or abnormal cells by inducing apoptosis or releasing cytotoxic molecules.",
			"T lymphocytes that suppress or regulate the immune response to prevent autoimmune reactions and maintain immune homeostasis.",
			"The process by which antibodies or complement proteins coat pathogens, making them more susceptible to phagocytosis by immune cells.",
			"Long-lived B cells that remain in the body after an infection has resolved, providing rapid and robust antibody responses upon re-exposure to the same pathogen.",
			"Long-lived T cells that \"remember\" previous encounters with specific antigens and mount a rapid and effective immune response upon re-exposure.",
			"A group of white blood cells characterized by the presence of granules in their cytoplasm. Granulocytes include neutrophils, eosinophils, and basophils, which play roles in inflammation, allergic reactions, and defense against pathogens.",
			"Cells found in connective tissues that release histamine and other inflammatory mediators in response to allergens or pathogens, contributing to allergic reactions and inflammation.",
			"Antigen-presenting cells that capture, process, and present antigens to T cells, initiating adaptive immune responses.",
			"A vesicle formed by the engulfment of a particle, such as a bacterium or virus, by a phagocytic cell. Phagosomes fuse with lysosomes to form phagolysosomes, where the engulfed particle is degraded.",
			"Immunity that develops after exposure to a pathogen or through vaccination, involving the production of specific antibodies and memory cells.",
			"The suppression or weakening of the immune system, either naturally or as a result of medical treatment, to prevent rejection of transplanted organs or to treat autoimmune diseases.",
			"An easter egg. Also, it is a disease when the immune system mistakenly attacks healthy skin cells, causing rapid turnover of skin cells."
			};
	}	
}