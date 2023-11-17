package modelPack;

/**
 * 自作ユーティリティー管理用クラス
 *
 * @author N.Fukuda
 */
public class Utilities {

	/**
	 * レコード数を受け取って､20件毎のページ遷移する為のパーツを生成する
	 *
	 * @param servlet URL生成時に必要なpathの一部(thred,resの何れか)
	 * @param id URLにパラメータとして不可するthread_id
	 * @param recordCount (同一thread_idの)全体レコード数
	 * @return 生成したページ遷移用パーツ
	 */
	public static String editPages(String servlet, String threadId, int recordCount) {
		String pages = "<p class=\"editPages\">ページ指定表示&nbsp;"; //p開始タグで始まり

		if (threadId.equals("")) {
			pages += ("(スレッド制作順)&nbsp;&nbsp;");
		}
		//↓わざと条件をtrueにして､ﾙｰﾌﾟ内にbreakがある事を暗示している
		//　(ﾍﾟｰｼﾞﾊﾟｰﾂの最期に"/"を付けないようにする為､ﾙｰﾌﾟの途中で抜ける)
		for (int i = 1; true; i++) {

			//a開始タグ & 基本URL
			pages += ("<a href=\"" + servlet + "?");

			//idパラメータ(レスページのみ)
			if (!threadId.equals("")) {
				pages += ("threadId=" + threadId + "&");
			}

			//pageパラメータ
			pages += ("page=" + i);

			//a開始タグ閉じ括弧 & 表示用ページNo & a閉じタグ
			pages += ("\">" + i + "</a>");

			//ループ抜け判定
			if (i * 20 >= recordCount) {
				break;
			}

			//表示用ページ分け記号
			pages += " / ";
		}

		return pages += "</p>"; //p閉じタグで終わる

	}

}