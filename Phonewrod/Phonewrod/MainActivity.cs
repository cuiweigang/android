using System;
using Android.App;
using Android.Content;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.OS;
using System.Collections.Generic;
using System.Linq;

namespace Phonewrod
{
    [Activity(Label = "Phonewrod", MainLauncher = true, Icon = "@drawable/icon")]
    public class MainActivity : Activity
    {
        static readonly List<string> phoneNumbers = new List<string>();
        protected override void OnCreate(Bundle bundle)
        {
            Console.WriteLine("##################################onCreate");
            base.OnCreate(bundle);

            SetContentView(Resource.Layout.Main);
            
            EditText phoneNumberText = FindViewById<EditText>(Resource.Id.PhoneNumberText);
            Button translateButton = FindViewById<Button>(Resource.Id.TranslateButton);
            Button callButton = FindViewById<Button>(Resource.Id.CallButton);
            Button callHistoryButton = FindViewById<Button>(Resource.Id.CallHistoryButton);

            callButton.Enabled = false;
            string translatedNumber = string.Empty;
            callHistoryButton.Enabled = phoneNumbers.Any();

            translateButton.Click += (object sender, EventArgs args) =>
            {
                translatedNumber = Core.PhonewordTranslator.ToNumber(phoneNumberText.Text);

                if (string.IsNullOrWhiteSpace(translatedNumber))
                {
                    callButton.Text = "Call";
                    callButton.Enabled = false;
                }
                else
                {
                    callButton.Text = "Call:" + translatedNumber;
                    callButton.Enabled = true;
                }
            };

            callButton.Click += (object sender, EventArgs e) =>
            {
                var callDialog = new AlertDialog.Builder(this);
                callDialog.SetMessage("Call" + translatedNumber + "?");
                callDialog.SetPositiveButton("Call", delegate
                {
                    phoneNumbers.Add(translatedNumber);

                    if (!callHistoryButton.Enabled)
                    {
                        callHistoryButton.Enabled = !callHistoryButton.Enabled;
                    }

                    var callIntent = new Intent(Intent.ActionCall);
                    callIntent.SetData(Android.Net.Uri.Parse("tel:" + translatedNumber));
                    StartActivity(callIntent);
                });

                callDialog.SetNegativeButton("Cancel", delegate { });

                callDialog.Show();
            };

            callHistoryButton.Click += (sender, e) =>
            {
                var intent = new Intent(this, typeof(CallHistoryActivity));
                intent.PutStringArrayListExtra("phone_numbers", phoneNumbers);
                StartActivity(intent);
            };
        }

        protected override void OnStart()
        {
            Console.WriteLine("##################################OnStart");
            base.OnStart();
        }

        protected override void OnResume()
        {
            Console.WriteLine("##################################OnResume");
            base.OnResume();
        }

        protected override void OnPause()
        {
            Console.WriteLine("##################################OnPause");
            base.OnPause();
        }

        protected override void OnStop()
        {
            Console.WriteLine("##################################OnStop");
            base.OnStop();
        }


    }
}

