package prod;

public class UserDB {
	private static User[] listaUsers;

	public User[] getListaUsers() {
		return listaUsers;
	}

	public static void setListaUsers(User[] listaUsers) {
		UserDB.listaUsers = listaUsers;
	}
	
	public User getUser(String login) {
		for (User user : listaUsers) {
			if (user.getLogin().equals(login)) return user;
		}
		return null;
	}
	
	public static boolean autenticar(String login, String senha) {
		for (User user : listaUsers) {
			if (user.getLogin().equals(login) && user.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}
}
