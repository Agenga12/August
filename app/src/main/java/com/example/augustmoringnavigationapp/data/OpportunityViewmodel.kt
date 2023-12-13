package com.example.augustmoringnavigationapp.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.augustmoringnavigationapp.models.Opportunity
import com.example.augustmoringnavigationapp.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class OpportunityViewmodel(var navController: NavHostController, var context:Context) {
    var authRepository:AuthRepository
    var progress:ProgressDialog

    init {
        authRepository = AuthRepository(navController,context)
        if (!authRepository.isLoggedIn()){
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun saveOpportunity(funderName:String, opportunityTitle:String,opportunityDescription:String , opportunityDeadline:String, opportunityAmount:String){
        var id = System.currentTimeMillis().toString()
        var opportunity = Opportunity(funderName,opportunityTitle,opportunityDescription,opportunityDeadline, opportunityAmount,id)
        var reference = FirebaseDatabase.getInstance().getReference()
            .child("Opportunities/$id")
        progress.show()
        reference.setValue(opportunity).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun viewOpportunities(opportunityMutableState:MutableState<Opportunity>, opportunitySnapshotStateList:SnapshotStateList<Opportunity>): SnapshotStateList<Opportunity> {
        var ref = FirebaseDatabase.getInstance().getReference().child("Opportunities")

        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                progress.dismiss()
                opportunitySnapshotStateList.clear()
                for (snap in snapshot.children){
                    val value = snap.getValue(Opportunity::class.java)
                    opportunityMutableState.value = value!!
                    opportunitySnapshotStateList.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return opportunitySnapshotStateList
    }

    fun deleteOpportunity(id:String){
        var delRef = FirebaseDatabase.getInstance().getReference()
                                .child("Opportunities/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "Opportunity deleted", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateOpportunity(funderName:String, opportunityTitle:String,opportunityDescription:String , opportunityDeadline:String, opportunityAmount: String, id:String){
        var updateRef = FirebaseDatabase.getInstance().getReference()
                                                    .child("Opportunities/$id")
        progress.show()
        var updateData = Opportunity(funderName, opportunityTitle,opportunityDescription,opportunityDeadline, opportunityAmount, id)
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }


}