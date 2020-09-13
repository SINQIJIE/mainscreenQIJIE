package c.example.mainscreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PaymentAdapter extends FirebaseRecyclerAdapter<Payments,PaymentAdapter.viewHolder> {

    public PaymentAdapter(@NonNull FirebaseRecyclerOptions<Payments> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PaymentAdapter.viewHolder holder, int position, @NonNull Payments model) {
        holder.mName.setText(model.getName());
        holder.mAddress.setText(model.getAddress());
        holder.mNote.setText(model.getNotes());
        holder.mPayment.setText(model.getPaymentMethod());
        holder.mPhone.setText(model.getPhone());
    }

    @NonNull
    @Override
    public PaymentAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paymentlistitem,parent,false);
        return new viewHolder(view);
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView mName,mNote,mAddress,mPhone,mPayment;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            mName=(TextView) itemView.findViewById(R.id.BName);
            mAddress=(TextView) itemView.findViewById(R.id.BAddress);
            mNote=(TextView) itemView.findViewById(R.id.BNotes);
            mPayment=(TextView) itemView.findViewById(R.id.BPayemntMenthod);
            mPhone=(TextView) itemView.findViewById(R.id.BPhone);
        }
    }
}
