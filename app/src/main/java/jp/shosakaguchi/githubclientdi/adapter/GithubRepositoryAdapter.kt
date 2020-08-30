import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import jp.shosakaguchi.githubclientdi.R
import jp.shosakaguchi.githubclientdi.model.GithubRepository

class GithubRepositoryAdapter(items: List<GithubRepository>, ctx: Context) :
    ArrayAdapter<GithubRepository>(ctx, R.layout.list_item, items) {

    private class AttractionItemViewHolder {
        internal var user: TextView? = null
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view

        val viewHolder: AttractionItemViewHolder

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.list_item, viewGroup, false)

            viewHolder = AttractionItemViewHolder()
            viewHolder.user = view.findViewById<View>(R.id.user) as TextView
        } else {
            viewHolder = view.tag as AttractionItemViewHolder
        }

        val attraction = getItem(i)

        viewHolder.user!!.text = attraction?.name

        view?.tag = viewHolder

        return view!!
    }
}