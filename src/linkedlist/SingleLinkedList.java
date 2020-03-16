package linkedlist;

public class SingleLinkedList {
	private SingleNode tete;
	private SingleNode queue;
	private int size;
	
	//Creation de la linked list
	public SingleNode createSingleLinkedList (char nodeValue) {
		tete = new SingleNode();
		SingleNode node = new SingleNode();
		node.setValueChar(nodeValue);
		node.setNext(null);
		tete = node;
		queue = node;
		size = 1;
		return tete;
	} //Fin de la methode
	
	public SingleNode getTete() {
		return tete;
	}
	
	public void setTete(SingleNode tete) {
		this.tete = tete;
	}
	
	public SingleNode getQueue() {
		return queue;
	}
	
	public void setQueue(SingleNode queue) {
		this.queue = queue;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	//Regarde si la linked list existe
	public boolean existanceOfLinkedList() {
		//Si la tete est null, retourne faux, sinon retourne vrai
		return tete != null;
	} //Fin de la methode
	
	//Insertion dans la linked list
	public void insertionDansLinkedList(char nodeValue, int location) {
		SingleNode node = new SingleNode(); //Creation d'un nouveau noeud
		node.setValueChar(nodeValue); //Inserer la valeur du noeud
		if (!existanceOfLinkedList()) { //Si la linked list n'esxiste pas 
			System.out.println("La linked list n'existe pas.");
			return;
		} else if (location == 0) { //Insertion a la premiere position
			node.setNext(tete); //on relie le noeud au noeud qui est a la tete de la liste chainer
			tete = node; //on dit maintenant a la liste que la tete est le nouveau noeud ajouter
		} else if (location >= getSize()) { //Si on entre une position plus grande que la taille, on fait qu'ajouter le noeud a la fin
			node.setNext(null); //Puisque ce n'est qu'une simple linked list et non une simple linked list circulaire, on ne relie pas la queue a la tete
			queue.setNext(node); //On relie le noeud a la queue au nouveau noeud
			queue = node; //On indique a la liste que la queue est maintenant le nouveau noeud ajouter
		} else { //Si on ajoute un noeud au millieu(pas a la tete ni a la queue) de la liste
			SingleNode nodeTemporaire = new SingleNode(); //Creation d'un noeud temporaire. Celui-ci nous permettra de relier certains noeud ensembles
			int index = 0;
			while (index < location -1) { //Aller a la position ou on souhaite ajouter le node
				nodeTemporaire = nodeTemporaire.getNext(); //Permet d'aller chercher le node suivant
				index++;
			} //Fin de la boucle
			
			/*Pour l'instant, le noeud temporaire pointe sur le noeud suivant et non le nouveau noeud. C'est pourquoi on veut creer une variable de type SingleNode
			afin de garder une reference sur celui-ci lorsqu'on modifiera le noeud temporaire pour qu'il pointe sur le nouveau noeud.
			Imaginons que le noeud temporaire est a la position 3 et qu'on veut ajouter le nouveau noeud a la position 4 */
			
			SingleNode nextNode = nodeTemporaire.getNext(); //Le noeud apres le noeud temporaire. Cela servira pour relier le nouveau noeud au suivant(presentement position 4) 
			nodeTemporaire.setNext(node); //Le noeud temporaire pointe desormais sur le nouveau noeud et ne pointe plus sur le noeud suivant(position X)
			node.setNext(nextNode); //Le nouveau noeud pointe sur le noeud qui etait a la postion 4. Or, pusiqu'on a relier le noeud temporaire
									//au nouveau noeud, celui-ci est desormais a la position 4 et le 'nextNode' est maintenant a la position 5.
			setSize(getSize() + 1); //Agrandi la taille de la linked list	
		} //Fin du else
	} //Fin de la methode
	
	//Traverser la linked list
	public void traverserLaLinkedList() {
		if (!existanceOfLinkedList()) {
			System.out.println("La linked list n'existe pas.");
			return;
		}
		SingleNode nodeTemporaire = tete;
		for (int i = 0; i < getSize(); i++) {
			System.out.print(nodeTemporaire.getValueChar() + " ");
			nodeTemporaire = nodeTemporaire.getNext();
		} //Fin de la boucle
	} //Fin de la methode
	
	//Delete toute la linked list
	public void deleteLinkedList() {
		tete = null;
		queue = null;
		System.out.println("La linked list a ete supprime");
	} //Fin de la methode
	
	//Rechercher un noeud avec sa valeur
	public boolean rechercherNode(char nodeValue) {
		if (!existanceOfLinkedList()) {
			System.out.println("La linked list n'existe pas.");
			return false;
		}
		SingleNode nodeTemporaire = tete;
		for (int i = 0; i < getSize(); i++) {
			if (nodeTemporaire.getValueChar() == nodeValue) {
				System.out.println("Le noeud a ete trouve a la position: "+ i +"");
				return true;
			} //Fin du if
			nodeTemporaire = nodeTemporaire.getNext();
		} //Fin de la boucle
		System.out.println("Le noeud n'a pas ete trouve.");
		return false;
	} //Fin de la methode
	
	public String locationValue(int location) {
		if (!existanceOfLinkedList())
			return "La liste n'existe pas";
		SingleNode nodeTemporaire = tete;
		for (int i = 0; i < getSize(); i++) {
			System.out.print(nodeTemporaire.getValueChar() + " ");
			nodeTemporaire = nodeTemporaire.getNext();
			if (i == location - 1) 
				return "" + nodeTemporaire.getValueChar();
		} //Fin de la boucle
		return "Location non disponible";
	}
	
	public void deleteNode(int location) {
		if (!existanceOfLinkedList()) {
			System.out.println("La liste n'existe pas.");
			return;
		} else if (location == 0) {
			tete = tete.getNext(); 
			setSize(getSize() -1);
			//Le garbage collector s'occupe de supprimer correctement le noeud
			if (getSize() == 0)// S'il n'y a plus de node dans la liste
				queue = null;
		} else if (location >= getSize()) {
			SingleNode nodeTemporaire = tete;
			for (int i = 0; i < getSize() -1; i++) {
				nodeTemporaire = nodeTemporaire.getNext();
			} //Fin de la boucle
			if (nodeTemporaire == tete) {
				queue = tete = null;
				setSize(getSize() - 1); 
				return;
			} //Fin du if
			nodeTemporaire.setNext(null);
			queue = nodeTemporaire;
			setSize(getSize() - 1);
		} else {
			SingleNode nodeTemporaire = tete;
			for (int i = 0; i < location - 1; i++) {
				nodeTemporaire = nodeTemporaire.getNext();
			} //Fin de la boucle
			nodeTemporaire.setNext(nodeTemporaire.getNext().getNext()); //Le noeud temporaire pointe deux noeud plus loin ce qui enleve la reference au noeud qu'on souhaite supprimer
			setSize(getSize() - 1);
		} //Fin du else
	} //Fin de la methode
} //Fin de la classe
