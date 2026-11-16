using System;
using System.Data;
using System.Data.SqlClient;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.DAL
{
    public class JournalEntryDAL
    {
        public DataTable GetAll()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetAllJournalEntries");
        }

        public DataTable GetLines(int entryID)
        {
            return ConnectionHelper.ExecuteQuery("sp_GetJournalEntryLines",
                new SqlParameter("@Entry_ID", entryID));
        }

        public int AddEntry(JournalEntry je)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddJournalEntry",
                new SqlParameter("@Description", je.Description),
                new SqlParameter("@Total_Debit", je.Total_Debit),
                new SqlParameter("@Total_Credit", je.Total_Credit));
            return result != null ? Convert.ToInt32(result) : 0;
        }

        public void AddLine(JournalEntryLine line)
        {
            ConnectionHelper.ExecuteNonQuery("sp_AddJournalEntryLine",
                new SqlParameter("@Entry_ID", line.Entry_ID),
                new SqlParameter("@Account_ID", line.Account_ID),
                new SqlParameter("@Debit", line.Debit),
                new SqlParameter("@Credit", line.Credit));
        }
    }
}
