package com.rackluxury.lamborghini.reddit.adapters;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.rackluxury.lamborghini.reddit.customtheme.CustomThemeWrapper;
import com.rackluxury.lamborghini.R;
import com.rackluxury.lamborghini.reddit.ReportReason;

public class ReportReasonRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<ReportReason> generalReasons;
    private ArrayList<ReportReason> rules;
    private final int primaryTextColor;
    private final int colorAccent;

    public ReportReasonRecyclerViewAdapter(CustomThemeWrapper customThemeWrapper, ArrayList<ReportReason> generalReasons) {
        this.generalReasons = generalReasons;
        primaryTextColor = customThemeWrapper.getPrimaryTextColor();
        colorAccent = customThemeWrapper.getColorAccent();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReasonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_report_reason, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ReasonViewHolder) {
            ReportReason reportReason;
            if (position >= generalReasons.size()) {
                reportReason = rules.get(holder.getAdapterPosition() - generalReasons.size());
            } else {
                reportReason = generalReasons.get(holder.getAdapterPosition());
            }
            ((ReasonViewHolder) holder).reasonTextView.setText(reportReason.getReportReason());
            ((ReasonViewHolder) holder).checkBox.setChecked(reportReason.isSelected());
        }
    }

    @Override
    public int getItemCount() {
        return rules == null ? generalReasons.size() : rules.size() + generalReasons.size();
    }

    public void setRules(ArrayList<ReportReason> reportReasons) {
        this.rules = reportReasons;
        notifyDataSetChanged();
    }

    public ReportReason getSelectedReason() {
        if (rules != null) {
            for (ReportReason reportReason : rules) {
                if (reportReason.isSelected()) {
                    return reportReason;
                }
            }
        }

        for (ReportReason reportReason : generalReasons) {
            if (reportReason.isSelected()) {
                return reportReason;
            }
        }

        return null;
    }

    public ArrayList<ReportReason> getGeneralReasons() {
        return generalReasons;
    }

    public ArrayList<ReportReason> getRules() {
        return rules;
    }

    class ReasonViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.reason_text_view_item_report_reason)
        TextView reasonTextView;
        @BindView(R.id.check_box_item_report_reason)
        CheckBox checkBox;

        ReasonViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            reasonTextView.setTextColor(primaryTextColor);
            checkBox.setButtonTintList(ColorStateList.valueOf(colorAccent));

            checkBox.setOnClickListener(view -> {
                for (int i = 0; i < generalReasons.size(); i++) {
                    if (generalReasons.get(i).isSelected()) {
                        generalReasons.get(i).setSelected(false);
                        notifyItemChanged(i);

                    }
                }

                if (rules != null) {
                    for (int i = 0; i < rules.size(); i++) {
                        if (rules.get(i).isSelected()) {
                            rules.get(i).setSelected(false);
                            notifyItemChanged(i + generalReasons.size());
                        }
                    }
                }

                if (getAdapterPosition() >= generalReasons.size()) {
                    rules.get(getAdapterPosition() - generalReasons.size()).setSelected(checkBox.isChecked());
                } else {
                    generalReasons.get(getAdapterPosition()).setSelected(checkBox.isChecked());
                }
            });

            itemView.setOnClickListener(view -> checkBox.performClick());
        }
    }
}
